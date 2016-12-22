package presentation.hotelManager.list;

import java.io.IOException;

import org.controlsfx.control.PopOver;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;
import presentation.customer.information.ListViewCell;
import presentation.customer.information.PersonalListViewController;
import presentation.hotelManager.TestHotelManager;
import vo.ListVO;

public class ListViewController {
	
	
	@FXML
	private ToggleButton unexecutedToggleButton;
	
	@FXML
	private ToggleButton executedToggleButton;
	
	@FXML
	private ToggleButton abnormalToggleButton;
	
	@FXML
	private ToggleButton revokedToggleButton;
	
	@FXML
	private ListView<ListVO> simpleListView;
	
	private TestHotelManager mainApp;
	
	/*
	 * 0:δִ�ж���;1:��ִ�ж���;2:�쳣����;3:�ѳ�������;
	 */
	private int type;
	
	private ObservableList<ListVO> unexecutedLists;
	
	private ObservableList<ListVO> executedLists;
	
	private ObservableList<ListVO> abnormalLists;
	
	private ObservableList<ListVO> revokedLists;
	
	//private ObservableList<ListVO> showLists;
	
	
	public ListViewController() {
	}
	
	@FXML
	private void initialize() {
		//showLists = FXCollections.observableArrayList();
		unexecutedLists = FXCollections.observableArrayList();
		executedLists = FXCollections.observableArrayList();
		abnormalLists = FXCollections.observableArrayList();
		revokedLists = FXCollections.observableArrayList();
		
		for (int i = 0; i < 3; i++) {
			unexecutedLists.add(new ListVO(0, 0, 0, null, "", "", "", 0, false,null));
		}
		for (int i = 0; i < 5; i++) {
			executedLists.add(new ListVO(0, 0, 0, null, "", "", "", 0, false,null));
		}
		for (int i = 0; i < 7; i++) {
			abnormalLists.add(new ListVO(0, 0, 0, null, "", "", "", 0, false,null));
		}
		for (int i = 0; i < 90; i++) {
			revokedLists.add(new ListVO(0, 0, 0, null, "", "", "", 0, false, null));
		}
		showUnexecutedLists();
		//simpleListView.setItems(showLists);
		simpleListView.setCellFactory((ListView<ListVO> e) -> new SimpleListViewCell(this));
	}
	
	@FXML
	private void showUnexecutedLists() {
		
		simpleListView.setItems(unexecutedLists);
		//showLists.clear();
		//for (ListVO listVO : unexecutedLists) {
		//	showLists.add(listVO);
		//}
		type = 0;
	}
	
	@FXML
	private void showExecutedLists() {
		simpleListView.setItems(executedLists);
		//showLists.clear();
		//for (ListVO listVO : executedLists) {
		//	showLists.add(listVO);
		//}
		type = 1;
	}
	
	@FXML
	private void showAbnormalLists() {
		simpleListView.setItems(abnormalLists);
		//showLists.clear();
		//for (ListVO listVO : abnormalLists) {
		//	showLists.add(listVO);
		//}
		type = 2;
	}
	
	@FXML
	private void showRevokedLists() {
		simpleListView.setItems(revokedLists);
		//showLists.clear();
		//for (ListVO listVO : revokedLists) {
		//	showLists.add(listVO);
		//}
		type = 3;
	}
	
	public void showDetail(Label label, ListVO listVO) {
		simpleListView.getSelectionModel().select(-1);
		FXMLLoader loader = new FXMLLoader();
		AnchorPane anchorPane = null;
		try {
			switch (type) {
			case 0:
				loader.setLocation(ListViewController.class.getResource("UnExecutedListCell.fxml"));
				anchorPane = (AnchorPane) loader.load();
				UnexecutedListCellController uController = loader.getController();
				uController.setMainApp(mainApp);
				uController.setUpperController(this);
				break;
			case 1:
				loader.setLocation(ListViewController.class.getResource("ExecutedListCell.fxml"));
				anchorPane = (AnchorPane) loader.load();
				ExecutedListCellController eController = loader.getController();
				eController.setMainApp(mainApp);
				eController.setUpperController(this);
				break;
			case 2:
				loader.setLocation(ListViewController.class.getResource("AbnormalListCell.fxml"));
				anchorPane = (AnchorPane) loader.load();
				AbnormalListCellController aController = loader.getController();
				aController.setUpperController(this);
				break;
			case 3:
				loader.setLocation(ListViewController.class.getResource("RevokedListCell.fxml"));
				anchorPane = (AnchorPane) loader.load();
			default:
				break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		PopOver popOver = new PopOver(anchorPane);
		popOver.show(label);
	}
	
	
	public void setMainApp(TestHotelManager mainApp) {
		this.mainApp = mainApp;
	}
}
