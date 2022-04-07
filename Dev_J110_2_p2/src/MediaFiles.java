
public class MediaFiles extends FilesAbstract {
    
    private String mediafileFormat;
    private String mediaFileDescription;
    private MediaDuration mediaDuration; 

    public MediaFiles(String fileName, long fileSize, String mediafileFormat, String mediaFileDescription, int hour, int minute, int second) {
        super(fileName, fileSize);
        setMediafileFormat(mediafileFormat);
        setMediaFileDescription(mediaFileDescription);
        setMediaDuration(new MediaDuration(hour, minute, second));
    }
    public String getMediafileFormat() {
        return mediafileFormat;
    }
    public final void setMediafileFormat(String mediafileFormat) {
        if (mediafileFormat != null && !mediafileFormat.trim().isEmpty())
            this.mediafileFormat = mediafileFormat.trim();
        else
            throw new IllegalArgumentException("Необходимо указать формат файла.");       
    }
    
    public String getMediaFileDescription() {
        return mediaFileDescription;
    }
    
    public final void setMediaFileDescription(String mediaFileDescription) {
        if (mediaFileDescription != null && !mediaFileDescription.trim().isEmpty())
            this.mediaFileDescription = mediaFileDescription.trim();
        else
            throw new IllegalArgumentException("Поле <mediaFileDescription> не может пустым.");        
    }
    
    public MediaDuration getMediaDuration() {
        return mediaDuration;
    }
    public final void setMediaDuration(MediaDuration mediaDuration) {
        if(mediaDuration != null)
           this.mediaDuration = mediaDuration;
        else
            throw new IllegalArgumentException("Ссылка на объект <mediaDuration> не должна быть пустой");
    }
    
    //методы, при помощи которых можно напечатать строковое представление размера изображения и длительности медиа файла   
    @Override
    public void printFeatures() {
        System.out.printf("Длительность медиафайла %s составляет - часов:%02d, минут:%02d, секунд:%02d.%n", super.getFileName(), mediaDuration.hour, mediaDuration.minute, mediaDuration.second);
    }
    
    //вложенный класс MediaDuration для хранения данных о длительности медиафайла
    
public class MediaDuration {
        
        private int hour; 
        private int minute;
        private int second;

        public MediaDuration(int hour, int minute, int second) {
           if(!(hour == 0 & minute == 0 & second == 0)) {
             setHour(hour);
             setMinute(minute);
             setSecond(second); }
           else
             throw new IllegalArgumentException("Длительность файла должна быть больше ноля.");           
        }
        
        //getter’ы для доступа к полям класса MediaDuration
        public int getHour() {
            return hour;
        }
        
        public int getMinute() {
            return minute;
        }
        
        public int getSecond() {
            return second;
        }   
        
        //setter’ы для изменения полей класса MediaDuration
        public final void setHour(int hour) {
            if(hour >= 0)
                this.hour = hour;
            else
                throw new IllegalArgumentException("Параметры времени не могут иметь отрицательное значение.");
        }
        
        public final void setMinute(int minute) {
            if(minute >= 0)
                this.minute = minute;
            else
                throw new IllegalArgumentException("Параметры времени не могут иметь отрицательное значение.");
        }  
        
        public final void setSecond(int second) {
            if(second >= 0)
               this.second = second;  
            else  
               throw new IllegalArgumentException("Параметры времени не могут иметь отрицательное значение.");           
        }        
    }
}