import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    final static Charset ENCODING = StandardCharsets.UTF_8;
    public static void main(String[] args) {
        if(args == null || args.length<1){
            System.out.println("Please provide text file as input that contains list of patch files");
            System.exit(0);
        }
	    System.out.println("FILE INPUT : " + args[0]);
        try {
            //FileReader reader = new FileReader(args[0]);
            List<String> lines = Main.readSmallTextFile(args[0]);
            for(int i=0;i<lines.size();i++){
                String line = lines.get(i);
                String[] linesArr = line.split("/");
                String filename = linesArr[linesArr.length - 1];
                String folder = "patch/" + line.replace(filename,"");
                System.out.println(line);
                File dir = new File(folder);
                if(!dir.exists()){
                    System.out.println("MKDIR");
                    dir.mkdirs();
                }
                File file = new File(line);
                if(file.exists()){
                    Main.copy(line, folder + "/" + filename);
                }
            }
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    static List<String> readSmallTextFile(String aFileName) throws IOException {
        Path path = Paths.get(aFileName);
        return Files.readAllLines(path, ENCODING);
    }
    static void copy(String inputFile, String outPutFile){
        InputStream inStream = null;
        OutputStream outStream = null;

        try{

            File afile =new File(inputFile);
            if(afile.exists()){
                File bfile =new File(outPutFile);

                inStream = new FileInputStream(afile);
                outStream = new FileOutputStream(bfile);

                byte[] buffer = new byte[1024];

                int length;
                //copy the file content in bytes
                while ((length = inStream.read(buffer)) > 0){

                    outStream.write(buffer, 0, length);

                }

                inStream.close();
                outStream.close();

                System.out.println("File is copied successful!");
            }
            else{
                 System.out.println(inputFile + " does not exist!");
            }

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
