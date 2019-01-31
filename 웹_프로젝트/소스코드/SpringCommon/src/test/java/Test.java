import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import edu.iot.common.model.Restaurant;

public class Test {

	public static void main(String[] args) {
		ArrayList<Restaurant> list = new ArrayList<>();

		try {
			BufferedReader reastaurant = new BufferedReader(new FileReader("C:/Temp/restaurant.txt"));
			String data;
			while ((data = reastaurant.readLine()) != null) {
				String[] i =data.split("\t");
				if(i.length != 7) continue;
				System.out.println(data);
				Restaurant r = new Restaurant(
									0, //  Long.parseLong(i[0]), 
									i[1], i[2], i[3], i[4], i[5], i[6]);
				list.add(r);
				System.out.println(r);
				
			}
			reastaurant.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	}


