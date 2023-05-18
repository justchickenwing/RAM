package ram;

public enum File {
	ralFile("src\\main\\java\\ram\\ralfile.txt"),
	memoryFile("src\\main\\java\\ram\\memoryfile.txt");
    private final String path;
    /**
     * constructor for the enum File
     * @param path the name of the file which path you need
     */
    private File(String path) {
        this.path = path;
    }
    /**
     * returns the path of the file
     * @return
     */
    public String getPath() {
        return path;
    }
}
