
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
        if (textFileFormat != null && !textFileFormat.trim().isEmpty())
            this.textFileFormat = textFileFormat.trim();
        else
            throw new IllegalArgumentException("Необходимо указать формат файла.");
        
    }
    public int getNumberOfPages() {
        return numberOfPages;
    }
    public final void setNumberOfPages(int numberOfPages) {
        if(numberOfPages > 0)
            this.numberOfPages = numberOfPages;
        else
            throw new IllegalArgumentException("Количество страниц должно быть больше ноля.");
        
    }
    
    //методы, при помощи которых можно напечатать строковое представление размера изображения и длительности медиа файла   
    @Override
    public void printFeatures() {
        System.out.printf("Количество страниц в текстовом файле \"%s\" - %d%n", super.getFileName(), numberOfPages);
    }
    
}
