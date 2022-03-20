
public class ImageFiles extends FilesAbstract {
    
    private String imageFileFormat;
    private ImageSize imageSize;

    public ImageFiles(String fileName, long fileSize, String imageFileFormat, int imageFileWidth, int imageFileHeight) {
        super(fileName, fileSize);
        setImageFileFormat(imageFileFormat);
        imageSize = new ImageSize(imageFileWidth, imageFileHeight);
    }
    public String getImageFileFormat() {
        return imageFileFormat;
    }
    public final void setImageFileFormat(String imageFileFormat) {
        if(imageFileFormat == null)
            throw new IllegalArgumentException("Необходимо указать формат файла.");
        
        this.imageFileFormat = imageFileFormat;     
    }    
    public ImageSize getImageSize() {        
        return imageSize;
    }
    public void setImageSize(ImageSize imageSize) {
        if(imageSize == null)
            throw new IllegalArgumentException("Ссылка на объект <imageSize> не должна быть пустой");
        
        this.imageSize = imageSize;
    }
        @Override
        public void print() {   
            System.out.printf("Размер изображения, хранящегося в файле %s составляет %dx%d%n", super.getFileName(), imageSize.imageFileWidth, imageSize.imageFileHeight);
    }
public class ImageSize {
    
    private int imageFileWidth;
    private int imageFileHeight;

    public ImageSize(int imageFileWidth, int imageFileHeight) {        
        setImageFileWidth(imageFileWidth);
        setImageFileHeight(imageFileHeight);
        }
        public int getImageFileWidth() {
            return imageFileWidth;
        }
        public final void setImageFileWidth(int imageFileWidth) {
            if(imageFileWidth <= 0)
                throw new IllegalArgumentException("Ширина изображения в файле должна быть больше ноля.");
            
            this.imageFileWidth = imageFileWidth;
        }
        public int getImageFileHeight() {
            return imageFileHeight;
        }
        public final void setImageFileHeight(int imageFileHeight) {
            if(imageFileHeight <= 0)
                throw new IllegalArgumentException("Высота изображения в файле должна быть больше ноля.");
               
            this.imageFileHeight = imageFileHeight;
        } 
        public void printImageSize() {
            System.out.printf("Размер изображения в фале %s составляет %dx%d", ImageFiles.super.getFileName(), imageFileWidth, imageFileHeight);
    }
}
}

