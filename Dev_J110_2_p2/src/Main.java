
public class Main {

    public static void main(String[] args) {
        
        FilesAbstract file1 = new TextFiles("Аннотации_к_выставке", 54797, "docx", 16);
        FilesAbstract file2 = new TextFiles("Gangut_all", 939866, "pdf ", 215);
        FilesAbstract file3 = new TextFiles("ГОСТ-2018", 527194, "odt ", 21);
        
        FilesAbstract file4 = new ImageFiles("Анапа_2019", 2099297, "jpg", 2816, 2112);
        FilesAbstract file5 = new ImageFiles("Дача_92", 645846, "png", 896, 611);
        FilesAbstract file6 = new ImageFiles("dog", 954562, "bmp", 124, 184);
        
        FilesAbstract file7 = new MediaFiles("Main_Title_Theme-WESTWORLD", 18026574, "wav ", "Вступительная тема к сериалу WESTWORLD, Ramin Djawadi, 2018", 0, 1, 42);
        FilesAbstract file8 = new MediaFiles("Poka", 4876441, "mp3 ", "\"Пока\", Алена Свиридова, 1998", 0, 3, 22);
        FilesAbstract file9 = new MediaFiles("En_Aranjuez_Con_Tu_Amor", 19125332, "flac", "\"En Aranjuez Con Tu Amor\", Andrea Bocelli - Concerto, 2018", 0, 3, 35);
        
        FilesAbstract file10 = new VideoFiles("Гараж", 2175654652l, "avi", "Полнометражный художественный фильм \"Гараж\", киностудия \"Мосфильм\", 1979", 1, 35, 14, 640, 480);
        FilesAbstract file11 = new VideoFiles("Щит_и_меч", 8155644652l, "mp4", "Полнометражный четырехсерийный художественный фильм \"Щит и меч\", киностудия \"Мосфильм\", 1968", 5, 12, 11, 640, 480);
        FilesAbstract file12 = new VideoFiles("Shrek", 3172654952l, "mov", "Полнометражный мультфильм \"Shrek\", студия \"DreamWorks Animation\", 2001", 1, 32, 1, 1920, 1080);
        
        FilesAbstract[] files = new FilesAbstract[] {file1, file2, file3, file4, file5, file6, file7, file8, file9, file10, file11, file12};
        
        FilesAbstract.printAll(files);
        
        System.out.println();
/*   Несмотря на то, что метод printAll(FilesAbstract[] files) работает с типом данных FilesAbstract, он превосходно спраяляется и c типами данных, для которых FilesAbstract является родительским типом.
   Передавая в метод printAll(FilesAbstract[] files) данные типа MediaFiles мы надеемся на положительный результат, т.к:
   1. эти два типа данных являются совместимыми;
   2. FilesAbstract является более широким типом по сравнению с MediaFiles.     
        */
        MediaFiles mfile1 = new MediaFiles("Main_Title_Theme-WESTWORLD", 18026574, "wav ", "Вступительная тема к сериалу WESTWORLD, Ramin Djawadi, 2018", 0, 1, 42);
        MediaFiles mfile2 = new MediaFiles("Poka", 4876441, "mp3 ", "\"Пока\", Алена Свиридова, 1998", 0, 3, 22);
        MediaFiles mfile3 = new MediaFiles("En_Aranjuez_Con_Tu_Amor", 19125332, "flac", "\"En Aranjuez Con Tu Amor\", Andrea Bocelli - Concerto, 2018", 0, 3, 35);
        MediaFiles mfile4 = new MediaFiles("Кукла_колдуна", 29890457, "mp4a", "\"Кукла колдуна\", Король и шут - Собрание, 2002", 0, 3, 22);
        
        MediaFiles[] mfiles = new MediaFiles[] {mfile1, mfile2, mfile3, mfile4};
        
        FilesAbstract.printAll(mfiles); 
        //Работа метода, позволяющего получить основные параметры файлов
        //Текстовые
        file1.print();
        // Картинки
        file4.print();
        // Медиа - аудио
        file7.print();
        // Медиа - видео
        file12.print();
    }   
}
