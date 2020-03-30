import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NoteTest {

    Note note;

    @Before
    public void setUP(){
        note =  Note.of("Marcin", 4.5f);
    }

    @Test
    public void testGetName(){
        assertThat( note.getName()).isEqualTo("Marcin");
    }

    @Test
    public void testGetNote(){
        assertThat(note.getNote()).isBetween(2.0f,6.0f).isEqualTo(4.5f);
    }

    @Test
    public void testNullAsAName(){
        assertThatThrownBy(() -> {
            Note newNone = Note.of (null, 3.0f);
        }).isInstanceOf(IllegalArgumentException.class).hasMessage("Imię ucznia nie może być null");
    }

    @Test
    public void testEmptyName(){
        assertThatThrownBy(() -> {
            Note newNone = Note.of ("", 2.0f);
        }).isInstanceOf(IllegalArgumentException.class).hasMessage("Imię ucznia nie może być puste");
    }

    @Test
    public void testUncommonName(){
        assertDoesNotThrow(Note newNone = Note.of ("Jaga2342", 3.5f)) ;
        }

    @Test
    public void testNoteUnder(){
        assertThatThrownBy(() -> {
            Note newNone = Note.of ("Marcin", 0.5f);
        }).isInstanceOf(IllegalArgumentException.class).hasMessage("Niewłaściwa ocena");
    }

    @Test
    public void testNoteAbove(){
        assertThatThrownBy(() -> {
            Note newNone = Note.of ("Marcin", 8);
        }).isInstanceOf(IllegalArgumentException.class).hasMessage("Niewłaściwa ocena");
    }
}