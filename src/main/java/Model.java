import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Model {
    private File directory = new File("C://Users");
    private boolean isCheckJPEG;
    private boolean isCheckPNG;
    private boolean isCheckExcel;

    public Model() {
    }

    public Model(String pathname, boolean checkJPEG, boolean checkPNG, boolean checkExcel) {

        this.directory = new File(pathname);
        this.isCheckJPEG = checkJPEG;
        this.isCheckPNG = checkPNG;
        this.isCheckExcel = checkExcel;
    }

    public Model(boolean checkJPEG, boolean checkPNG, boolean checkExcel) {
        this.isCheckJPEG = checkJPEG;
        this.isCheckPNG = checkPNG;
        this.isCheckExcel = checkExcel;
    }

    public List<String> deleteFilesInDirectory() {
        ArrayList<String> listView = new ArrayList<>();
        if (directory.isDirectory()) {
            for (File file : directory.listFiles())
                if (file.getName().matches(regexMatching())) {
                    listView.add(file.getName());
                    System.out.println(file.getName());
                    file.delete();
                }
        }
        return listView;
    }

    public String regexMatching() {
        String regex = "";
        if (isCheckJPEG) regex += Regex.JPEG.getExpression();
        if (isCheckPNG) regex += Regex.PNG.getExpression();
        if (isCheckExcel) regex += Regex.EXCEL.getExpression();
        return regex;
    }


    public static class Builder {
        private Model model;

        public Builder() {
            model = new Model();
        }

        public Builder pathName(String path){
            model.directory = new File(path);
            return this;
        }

        public Builder isCheckJPEG(boolean check){
            model.isCheckJPEG = check;
            return this;
        }

        public Builder isCheckPNG(boolean check){
            model.isCheckPNG = check;
            return this;
        }

        public Builder isCheckExcel(boolean check){
            model.isCheckExcel = check;
            return this;
        }

        public Model build() {
            return model;
        }
    }

}
