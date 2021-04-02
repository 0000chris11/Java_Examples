package resources;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GetResourcesTest {
    private static final String LINE = "-----------------------------------------";

    private void loadResource (String resource) throws IOException {
        URL u = this.getClass().getResource(resource);
        loadResourceByUrl(u, resource);
    }

    private void loadResourceWithContextLoader (String resource) throws IOException {
        URL u = Thread.currentThread().getContextClassLoader().getResource(resource);
        loadResourceByUrl(u, resource);
    }

    private void loadResourceWithSystemClassLoader (String resource) throws IOException {
        URL u = ClassLoader.getSystemClassLoader().getResource(resource);
        loadResourceByUrl(u, resource);
    }

    private void loadResourceByUrl (URL u, String resource) throws IOException {
        System.out.println("-> attempting input resource: "+resource);
        if (u != null) {
            String path = u.getPath();
            path = path.replaceFirst("^/(.:/)", "$1");
            System.out.println("    absolute resource path found :\n    " + path);
            String s = new String(Files.readAllBytes(Paths.get(path)));
            System.out.println("    file content: "+s);
        } else {
            System.out.println("    no resource found: " + resource);
        }
    }

    public static void main (String[] args) throws IOException {
        GetResourcesTest a = new GetResourcesTest();

        String pkgResource = "TestResources.txt";
        String pkgAbsoluteResource = "/TestResources.txt";
        String rootResource = "TestResourcesRoot.txt";
        String rootAbsoluteResource = "/TestResourcesRoot.txt";

        System.out.println(LINE+"\nusing this.getClass().getResource\n"+LINE);
        a.loadResource(pkgResource);
        a.loadResource(pkgAbsoluteResource);
        a.loadResource(rootResource);
        a.loadResource(rootAbsoluteResource);

        System.out.println(LINE+"\n using current thread context loader\n"+LINE);
        a.loadResourceWithContextLoader(pkgResource);
        a.loadResourceWithContextLoader(pkgAbsoluteResource);
        a.loadResourceWithContextLoader(rootResource);
        a.loadResourceWithContextLoader(rootAbsoluteResource);


        System.out.println(LINE+"\n using ClassLoader.getSystemClassLoader()\n"+LINE);
        a.loadResourceWithSystemClassLoader(pkgResource);
        a.loadResourceWithSystemClassLoader(pkgAbsoluteResource);
        a.loadResourceWithSystemClassLoader(rootResource);
        a.loadResourceWithSystemClassLoader(rootAbsoluteResource);

    }
}
