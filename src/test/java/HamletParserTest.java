import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class HamletParserTest {
    private String hamletText;
    private HamletParser hamletParser;

    @Before
    public void setUp() {
        this.hamletParser = new HamletParser();
        this.hamletText = hamletParser.getHamletData();
    }

    @Test
    public void testChangeHamletToLeon() {
        String s = hamletParser.replace1("Hamlet", "leon");
        Assert.assertFalse(s.toUpperCase().contains("HAMLET"));


    }

    @Test
    public void testChangeHoratioToTariq() {
        String s = hamletParser.replace1("horatio", "tariq");
        Assert.assertFalse(s.toUpperCase().contains("HORATIO"));

    }

    @Test
    public void testFindHoratio() {
        String s = hamletParser.replace1("hamlet", "leon");
        Assert.assertFalse(s.toUpperCase().contains("HAMLET"));
    }

    @Test
    public void testFindHamlet() {
        String s = hamletParser.replace1("HOratio", "tariq");
        Assert.assertFalse(s.toUpperCase().contains("HORATIO"));

    }
}