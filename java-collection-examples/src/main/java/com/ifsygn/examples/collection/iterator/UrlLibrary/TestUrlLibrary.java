public class TestUrlLibrary {

    public static void main(String[] args)
    {
        UrlLibrary urlLibrary = new UrlLibrary();

        urlLibrary.iterator();

        for (var url : urlLibrary)
            System.out.println(url);
    }
}

