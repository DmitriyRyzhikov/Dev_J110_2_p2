
public class MediaFiles extends FilesAbstract {
    
    private String mediafileFormat;
    private String mediaFileDescription;
    private MediaDuration mediaDuration; 

    public MediaFiles(String fileName, long fileSize, String mediafileFormat, String mediaFileDescription, int hour, int minute, int second) {
        super(fileName, fileSize);
        setMediafileFormat(mediafileFormat);
        setMediaFileDescription(mediaFileDescription);
        mediaDuration = new MediaDuration(hour, minute, second);
    }
    public String getMediafileFormat() {
        return mediafileFormat;
    }
    public final void setMediafileFormat(String mediafileFormat) {
        if(mediafileFormat == null)
            throw new IllegalArgumentException("Необходимо указать формат файла.");
        
        this.mediafileFormat = mediafileFormat;
    }
    public String getMediaFileDescription() {
        return mediaFileDescription;
    }
    public final void setMediaFileDescription(String mediaFileDescription) {
        if(mediaFileDescription == null)
            throw new IllegalArgumentException("Поле <mediaFileDescription> не может пустым.");
        
        this.mediaFileDescription = mediaFileDescription;
    }
    public MediaDuration getMediaDuration() {
        return mediaDuration;
    }
    public void setMediaDuration(MediaDuration mediaDuration) {
        if(mediaDuration == null)
            throw new IllegalArgumentException("Ссылка на объект <mediaDuration> не должна быть пустой");
        this.mediaDuration = mediaDuration;
    }
    @Override
    public void print() {
        System.out.printf("Длительность медиафайла %s составляет - часов:%02d, минут:%02d, секунд:%02d.%n", super.getFileName(), mediaDuration.hour, mediaDuration.minute, mediaDuration.second);
    }
    
public static class MediaDuration {
        
        int hour, minute, second;

        public MediaDuration(int hour, int minute, int second) {
            if(hour == 0 && minute == 0 && second == 0)
              throw new IllegalArgumentException("Длительность медиафайла должна быть больше ноля.");
            setHour(hour);
            setMinute(minute);
            setSecond(second);
        }
        public int getHour() {
            return hour;
        }
        public final void setHour(int hour) {
            if(hour < 0)
                throw new IllegalArgumentException("Параметры времени не могут иметь отрицательное значение.");
            this.hour = hour;
        }
        public int getMinute() {
            return minute;
        }
        public final void setMinute(int minute) {
            if(minute < 0)
                throw new IllegalArgumentException("Параметры времени не могут иметь отрицательное значение.");
            this.minute = minute;
        }
        public int getSecond() {
            return second;
        }
        public final void setSecond(int second) {
            if(second < 0)
                throw new IllegalArgumentException("Параметры времени не могут иметь отрицательное значение.");
            
            this.second = second;
        }        
    }
}