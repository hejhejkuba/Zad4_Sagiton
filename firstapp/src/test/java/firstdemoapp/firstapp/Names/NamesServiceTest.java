package firstdemoapp.firstapp.Names;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NamesServiceTest {
    @Autowired
    private MockMvc mockMvc;
    @InjectMocks
    NamesService namesService;
    @Mock
    private Names names;
    @Mock
    private Model model;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void postNameHal() {
        String value = "halView";
        String namesValue = namesService.postName("hal");
        assertEquals(value, namesValue);
    }

    @Test
    void postNameDavid() {
        String value = "davidView";
        String namesValue = namesService.postName("david");
        assertEquals(value, namesValue);
    }

    @Test
    void dispatcherMethodHal() {
        String result = namesService.dispatcherMethod("Hal", model);
        Assertions.assertEquals(result, "halView");
    }

    @Test
    void dispatcherMethodDavid() {
        String result = namesService.dispatcherMethod("David", model);
        Assertions.assertEquals(result, "davidView");
    }

    @Test
    void dispatcherMethodJohny() {

        TeapotException thrown = Assertions.assertThrows(TeapotException.class, () -> {
            namesService.dispatcherMethod("Johny", model);
        });

        Assertions.assertEquals("I'm a teapot", thrown.getMessage());
    }

    @Test
    void dispatcherMethodAnything() {
        String result = namesService.dispatcherMethod("Kuba", model);
        Assertions.assertEquals(result, "Default");
    }
}