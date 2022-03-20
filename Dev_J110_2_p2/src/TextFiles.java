
public class TextFiles extends FilesAbstract {
    
    private String textFileFormat;
    private int numberOfPages;

    public TextFiles(String fileName, long fileSize, String textFileFormat, int numberOfPages) {
        
        super(fileName, fileSize);
        setTextFileFormat(textFileFormat);
        setNumberOfPages(numberOfPages);
    }

    public String getTextFileFormat() {
        return textFileFormat;
    }

    public final void setTextFileFormat(String textFileFormat) {
        if(textFileFormat == null)
            throw new IllegalArgumentException("Необходимо указать формат файла.");
        
        this.textFileFormat = textFileFormat;
    }
    public int getNumberOfPages() {
        return numberOfPages;
    }
    public final void setNumberOfPages(int numberOfPages) {
        if(numberOfPages <= 0)
            throw new IllegalArgumentException("Количество страниц должно быть больше ноля.");
        
        this.numberOfPages = numberOfPages;
    }
    @Override
    public void print() {
        System.out.printf("Количество страниц в книге \"%s\" - %d%n", super.getFileName(), numberOfPages);
    }
    
}
