package hust.soict.globalict.aims.gui;

import javafx.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.ObservableList;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import hust.soict.globalict.aims.media.Track;
import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.order.Order;
import hust.soict.globalict.aims.PlayerException;

public class Aims_GUI extends Application {

	private Button newOrder;

	private List<Button> btn=new ArrayList<Button>();
	private List<Order> Olist=new ArrayList<Order>();
	private int j = -1;
	private int o;

	private GridPane grid = new GridPane();
	private TextField tftitle = new TextField();
	private TextField tfid = new TextField();
	private TextField tfcategory = new TextField();
	private TextField tfcost = new TextField();
	private TextField tflength = new TextField();
	private TextField tfdirector = new TextField();
	private TextField tfauthor = new TextField();
	private TextField tfartist = new TextField();
	private TextField tftotal = new TextField("0");
	private TextField cdLength = new TextField("0");
	private TextField trtitle = new TextField();
	private TextField trlength = new TextField();

	private TextField tfdate = new TextField();
	 

	private float c = 0;
	private int l = 0;
	private Alert a = new Alert(AlertType.NONE);
	private ObservableList<Media> list = FXCollections.observableArrayList();
	private ObservableList<Track> trlist = FXCollections.observableArrayList();

	@Override
	public void start(Stage primaryStage) {

		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(10);
		grid.setHgap(10);
		grid.setAlignment(Pos.CENTER);

		newOrder = new Button("New Order");
		grid.addRow(0, newOrder);
		newOrder.setOnAction(evt -> {
			j++;
			createOrder();

		});
		primaryStage.setTitle("AIMS");
		primaryStage.setScene(new Scene(grid, 600, 600));
		primaryStage.show();

	}

	public void createOrder() {
		if (j < Order.MAX_O) {
			Order anOrder=new Order();
			Olist.add(anOrder);
			Button Orderth = new Button("Order" + (j + 1));
			btn.add(Orderth);
			grid.addRow(j + 1, Orderth);
			Orderth.setOnAction(evt -> Orderinfo(Orderth,btn.indexOf(Orderth)));
			
			a.setAlertType(AlertType.CONFIRMATION);
			a.setContentText("A new Order is created");
			a.show();
		} else {
			a.setAlertType(AlertType.ERROR);
			a.setContentText("You cannot create more Orders");
			a.show();
		}

	}

	public void Orderinfo(Button b,int w) {
		o=w;
		
		Stage secondStage = new Stage();
		TableView<Media> table = new TableView<Media>();
		table.setEditable(false);

		TableColumn<Media, Integer> ID = new TableColumn<Media, Integer>("ID");
		TableColumn<Media, String> Title = new TableColumn<Media, String>("Title");
		TableColumn<Media, String> Category = new TableColumn<Media, String>("Category");
		TableColumn<Media, Float> Cost = new TableColumn<Media, Float>("Cost");

		ID.setCellValueFactory(new PropertyValueFactory<>("id"));
		Title.setCellValueFactory(new PropertyValueFactory<>("title"));
		Category.setCellValueFactory(new PropertyValueFactory<>("category"));
		Cost.setCellValueFactory(new PropertyValueFactory<>("cost"));
		table.getColumns().addAll(ID, Title, Category, Cost);
		
		ComboBox<String> additem = new ComboBox<String>();
		additem.getItems().addAll("Add Item", "Book", "DVD", "CD");
		additem.getSelectionModel().selectFirst();
		additem.setOnAction(evt -> itemInfo(additem.getValue()));
		
		list=FXCollections.observableArrayList(Olist.get(o).itemsOrdered);
		table.setItems(list);
		

		Button delItem = new Button("Delete Item");
		delItem.setOnAction(evt -> deleteItem());

		Button close = new Button("Close");
		close.setOnAction(evt -> secondStage.close());
		
		tftotal.setEditable(false);
		tftotal.setText(Float.toString(Olist.get(o).totalCost()));
		
		tfdate.setEditable(false);
		tfdate.setText(new SimpleDateFormat("dd-MM-yyyy").format(new Date()));

		GridPane grid2 = new GridPane();
		grid2.setPadding(new Insets(10, 10, 10, 10));
		grid2.setHgap(10);
		grid2.setVgap(10);
		grid2.setAlignment(Pos.CENTER);
		grid2.addRow(0, new Label("Date"), tfdate);
		grid2.addRow(2, table);
		grid2.addRow(3, new Label("TotalCost"), tftotal);
		grid2.addRow(4, additem, delItem, close);

		secondStage.setScene(new Scene(grid2, 800, 900));
		secondStage.setTitle(b.getText());
		secondStage.show();

	}

	public void itemInfo(String item) {
		switch (item) {
		case "Book":
			addBook();
			break;
		case "DVD":
			addDVD();
			break;
		case "CD":
			addCD();
			break;
		default:
			break;
		}
	}

	public void addBook() {
		Stage bookStage = new Stage();
		GridPane book = new GridPane();
		book.setHgap(10);
		book.setVgap(10);
		book.setAlignment(Pos.CENTER);
		book.addRow(0, new Label("ID"), tfid);
		book.addRow(1, new Label("Title"), tftitle);
		book.addRow(2, new Label("Category"), tfcategory);
		book.addRow(3, new Label("Cost"), tfcost);
		book.addRow(4, new Label("Authors"), tfauthor);

		Button Add = new Button("Add");
		Add.setOnAction(evt -> {
			Book b = new Book(Integer.parseInt(tfid.getText()), tftitle.getText(), tfcategory.getText(),
					Float.parseFloat(tfcost.getText()));
			if(list.size()<Order.MAX) {
				Olist.get(o).addMedia(b);
				list.add(b);
			
				tftotal.setText(Float.toString(Olist.get(o).totalCost()));
				a.setAlertType(AlertType.CONFIRMATION);
				a.setHeaderText("A new item is successfully added");
				a.setContentText("Click OK");
				a.show();
				tfid.clear();
				tftitle.clear();
				tfcategory.clear();
				tfcost.clear();
			}else {
				a.setAlertType(AlertType.ERROR);
				a.setContentText("The Order is full");
				a.show();
			}
			tfauthor.clear();
			bookStage.close();
		});
		book.addRow(5, Add);
		bookStage.setTitle("Book");
		bookStage.setScene(new Scene(book, 600, 600));
		bookStage.show();

	}

	public void addDVD() {
		Stage DVDStage = new Stage();
		GridPane dvd = new GridPane();
		dvd.setHgap(10);
		dvd.setVgap(10);
		dvd.setAlignment(Pos.CENTER);
		dvd.addRow(0, new Label("ID"), tfid);
		dvd.addRow(1, new Label("Title"), tftitle);
		dvd.addRow(2, new Label("Category"), tfcategory);
		dvd.addRow(3, new Label("Cost"), tfcost);
		dvd.addRow(4, new Label("Length"), tflength);
		dvd.addRow(5, new Label("Director"), tfdirector);

		Button Add = new Button("Add");
		Add.setOnAction(evt -> {
			DigitalVideoDisc d = new DigitalVideoDisc(Integer.parseInt(tfid.getText()), tftitle.getText(),
					tfcategory.getText(), Float.parseFloat(tfcost.getText()), Integer.parseInt(tflength.getText()),
					tfdirector.getText());
			if(list.size()<Order.MAX) {
				Olist.get(o).addMedia(d);
				list.add(d);
			
				tftotal.setText(Float.toString(Olist.get(o).totalCost()));
				a.setAlertType(AlertType.CONFIRMATION);
				a.setHeaderText("A new item is successfully added");
				a.setContentText("Do you want to play this item?");
				Optional<ButtonType> option=a.showAndWait();
				if(option.get()==ButtonType.OK) {
					try {
						d.play();
						Stage dvddisplay=new Stage();
						VBox dvdbox=new VBox();
						dvdbox.setSpacing(10);
						dvdbox.setAlignment(Pos.CENTER);
						dvdbox.getChildren().add(new Text("Playing DVD: "+d.getTitle()));
						dvdbox.getChildren().add(new Text("DVD Length: "+d.getLength()));
						dvddisplay.setTitle("DVD display");
						dvddisplay.setScene(new Scene(dvdbox,300,100));
						dvddisplay.show();
					}catch(Exception e) {
						a.setAlertType(AlertType.ERROR);
						a.setHeaderText("ILLIGAL DVD LENGTH");
						a.setContentText(e.getMessage());
						a.show();
					}
				}
				tfid.clear();
				tftitle.clear();
				tfcategory.clear();
				tfcost.clear();


			}else {
				a.setAlertType(AlertType.ERROR);
				a.setContentText("The Order is full");
				a.show();
			}
			tflength.clear();
			tfdirector.clear();
			DVDStage.close();
		});
		dvd.addRow(6, Add);
		DVDStage.setTitle("DVD");
		DVDStage.setScene(new Scene(dvd, 600, 600));
		DVDStage.show();

	}

	public void addCD() {
		Stage CDStage = new Stage();

		GridPane cd = new GridPane();
		cd.setPadding(new Insets(10, 10, 10, 10));
		cd.setHgap(10);
		cd.setVgap(10);
		cd.setAlignment(Pos.CENTER);

		cd.addRow(0, new Label("ID"), tfid);
		cd.addRow(1, new Label("Title"), tftitle);
		cd.addRow(2, new Label("Category"), tfcategory);
		cd.addRow(3, new Label("Cost"), tfcost);
		cd.addRow(4, new Label("Director"), tfdirector);
		cd.addRow(5, new Label("Artist"), tfartist);
		TableView<Track> trtable = new TableView<Track>();
		trtable.setEditable(false);
		TableColumn<Track, String> Title = new TableColumn<Track, String>("Title");
		TableColumn<Track, Integer> Length = new TableColumn<Track, Integer>("Length");
		Title.setCellValueFactory(new PropertyValueFactory<>("title"));
		Length.setCellValueFactory(new PropertyValueFactory<>("length"));
		trtable.setItems(trlist);
		trtable.getColumns().addAll(Title, Length);
		cd.addRow(8, trtable);

		Button addtrack = new Button("Add Track");
		addtrack.setOnAction(evt -> addTrack());
		Button removetrack = new Button("Remove Track");
		removetrack.setOnAction(evt -> removeTrack());
		cd.addRow(7, addtrack, removetrack);

		cdLength.setEditable(false);
		cd.addRow(9, new Label("Total Length"), cdLength);

		Button Add = new Button("Add");
		Add.setOnAction(evt -> {
			CompactDisc c = new CompactDisc(Integer.parseInt(tfid.getText()), tftitle.getText(), tfcategory.getText(),
					Float.parseFloat(tfcost.getText()), tfdirector.getText(), tfartist.getText());
			for(Track track:trlist)
				c.addTrack(track);
			
			if(list.size()<Order.MAX) {
				Olist.get(o).addMedia(c);
				list.add(c);
			
				tftotal.setText(Float.toString(Olist.get(o).totalCost()));
				a.setAlertType(AlertType.CONFIRMATION);
				a.setHeaderText("A new item is successfully added");
				a.setContentText("Do you want to play this item?");
				Optional<ButtonType> option=a.showAndWait();
				if(option.get()==ButtonType.OK) {
					try {
						c.play();
						Stage cddisplay=new Stage();
						VBox cdbox=new VBox();
						cdbox.setSpacing(10);
						cdbox.setAlignment(Pos.CENTER);
						cdbox.getChildren().add(new Text("Playing CD: "+c.getTitle()));
						cdbox.getChildren().add(new Text("CD Length: "+c.getLength()));
						for(Track track:trlist) {
							cdbox.getChildren().add(new Text("Playing Track: "+track.getTitle()));
							cdbox.getChildren().add(new Text("Track Length: "+track.getLength()));
						}
						cddisplay.setTitle("CD display");
						cddisplay.setScene(new Scene(cdbox,300,400));
						cddisplay.show();
					}catch(Exception e) {
						a.setAlertType(AlertType.ERROR);
						a.setHeaderText("ILLIGAL LENGTH");
						a.setContentText(e.getMessage());
						a.show();
					}
				}
				tfid.clear();
				tftitle.clear();
				tfcategory.clear();
				tfcost.clear();


			}else {
				a.setAlertType(AlertType.ERROR);
				a.setContentText("The Order is full");
				a.show();
			}
			
			
			
			tfdirector.clear();
			tfartist.clear();
			trtable.getItems().clear();
			cdLength.clear();
			l=0;
			CDStage.close();
		});
		cd.addRow(10, Add);
		CDStage.setTitle("CD");
		CDStage.setScene(new Scene(cd, 800, 800));
		CDStage.show();

	}



	public void deleteItem() {
		Stage delStage = new Stage();
		GridPane del = new GridPane();
		del.setHgap(10);
		del.setVgap(10);
		del.setAlignment(Pos.CENTER);
		del.addRow(0, new Label("ID"), tfid);
		Button ok = new Button("Delete");
		ok.setOnAction(evt -> {
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getId() == Integer.parseInt(tfid.getText())) {
					c -= list.get(i).getCost();
					tftotal.setText(Float.toString(c));
					list.remove(i);
					a.setAlertType(AlertType.CONFIRMATION);
					a.setContentText("The item is successfully removed");
					a.show();

				} else {
					a.setAlertType(AlertType.ERROR);
					a.setContentText("There are no items with this ID");
					a.show();
				}
			}
			tfid.clear();
			delStage.close();
		});
		del.addRow(2, ok);
		delStage.setTitle("DELETE");
		delStage.setScene(new Scene(del, 600, 600));
		delStage.show();
	}

	public void addTrack() {
		Stage TrackStage = new Stage();

		GridPane tr = new GridPane();
		tr.setHgap(10);
		tr.setVgap(10);
		tr.setAlignment(Pos.CENTER);
		tr.addRow(0, new Label("Title"), trtitle);
		tr.addRow(1, new Label("Length"), trlength);
		Button add = new Button("Add");
		tr.addRow(2, add);
		add.setOnAction(evt -> {
			Track track = new Track(trtitle.getText(), Integer.parseInt(trlength.getText()));
			if (!trlist.contains(track)) {
				trlist.add(track);
				
				
				l += track.getLength();
				cdLength.setText(Integer.toString(l));
				trtitle.clear();
				trlength.clear();
				TrackStage.close();
			} else {
				a.setAlertType(AlertType.ERROR);
				a.setContentText("The track has already existed");
				a.show();
			}
		});
		TrackStage.setTitle("Add Track");
		TrackStage.setScene(new Scene(tr, 500, 500));
		TrackStage.show();
	}

	public void removeTrack() {
		Stage TrackStage2 = new Stage();

		GridPane tr2 = new GridPane();
		tr2.setHgap(10);
		tr2.setVgap(10);
		tr2.setAlignment(Pos.CENTER);
		tr2.addRow(0, new Label("Title"), trtitle);
		tr2.addRow(1, new Label("Length"), trlength);
		Button remove = new Button("Remove");
		tr2.addRow(2, remove);
		remove.setOnAction(evt -> {
			Track track = new Track(trtitle.getText(), Integer.parseInt(trlength.getText()));
			if (trlist.contains(track)) {
				l -= track.getLength();
				cdLength.setText(Integer.toString(l));
				trlist.remove(track);
				trtitle.clear();
				trlength.clear();
				TrackStage2.close();
			} else {
				a.setAlertType(AlertType.ERROR);
				a.setContentText("The track does not exist");
				a.show();
			}
		});
		TrackStage2.setTitle("Remove Track");
		TrackStage2.setScene(new Scene(tr2, 500, 500));
		TrackStage2.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
