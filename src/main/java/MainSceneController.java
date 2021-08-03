import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;

public class MainSceneController {
    @FXML
    public Label textPath;
    @FXML
    public ListView listView;
    @FXML
    public CheckBox checkJPEG;
    @FXML
    public CheckBox checkPNG;
    @FXML
    public CheckBox checkExcel;

    private File selectedDirectory;
    private Model model;


    @FXML
    public void buttonClickedStart() {
        if (selectedDirectory == null)
            model = new Model.Builder()
                    .isCheckJPEG(checkJPEG.isSelected())
                    .isCheckPNG(checkPNG.isSelected())
                    .isCheckExcel(checkExcel.isSelected())
                    .build();

        else model = new Model.Builder()
                .pathName(selectedDirectory.getAbsolutePath())
                .isCheckJPEG(checkJPEG.isSelected())
                .isCheckPNG(checkPNG.isSelected())
                .isCheckExcel(checkExcel.isSelected())
                .build();


        loadListView();
    }

    @FXML
    public void buttonClickedSelectPath() {
        Stage stage = new Stage();
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Select the desired directory");

        selectedDirectory = directoryChooser.showDialog(stage);
        if (selectedDirectory != null)
            textPath.setText(selectedDirectory.getAbsolutePath());
    }

    private void loadListView() {
        for (String s : model.deleteFilesInDirectory())
            listView.getItems().add(s);
        listView.refresh();
    }
}
