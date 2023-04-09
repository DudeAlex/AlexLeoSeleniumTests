package school.redrover;

import org.testng.annotations.Test;

public class SchoolWebTest {
    String[] links = {"Courses", "Training", "About school", "Teachers"};
    @Test
    public void testCopyright() {
        WebUtils.copyright(links);
    }
}
