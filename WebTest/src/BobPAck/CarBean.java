package BobPAck;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.mysql.cj.jdbc.Blob;




@ManagedBean
@SessionScoped


public class CarBean implements Serializable {

	private static final long serialVersionUID = 6081417964063918994L;
	private Statement statement = null;


	public List<Car> getCars() throws ClassNotFoundException, SQLException {

		Connection connect = null;

		String url = "jdbc:mysql://localhost:3306/databasetest?";

		String username = "bobby";
		String password = "hoch";

		try {

		    Class.forName("com.mysql.cj.jdbc.Driver");
		    
			connect = DriverManager.getConnection(url, username, password);
			// System.out.println("Connection established"+connect);

		} catch (SQLException ex) {
			System.out.println("in exec");
			System.out.println(ex.getMessage());
		}

		List<Car> cars = new ArrayList<Car>();
		
		PreparedStatement pstmt = connect.prepareStatement("select Kunden_ID, Name, TelefonNr, Anschrift, Erreichabrkeit, Foto from kunden");
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {

			Car car = new Car();
			car.setCid(rs.getString("Kunden_ID"));
			car.setCname(rs.getString("Name"));
			car.setColor(rs.getString("TelefonNr"));
			car.setSpeed(rs.getString("Anschrift"));
			car.setMfdctry(rs.getString("Erreichabrkeit"));

			Blob blob = (Blob) rs.getBlob("Foto");
			byte[] imageBytes=blob.getBytes(1, (int)blob.length());
			String encodedImage=Base64.getEncoder().encodeToString(imageBytes);
			String image = "data:image/jpg;base64,"+encodedImage;
			System.out.print("<img src="+image+">");
			
			car.setPicture(image);
			

			cars.add(car);

		}

		// close resources
		rs.close();
		pstmt.close();
		connect.close();

		return cars;

	}

}