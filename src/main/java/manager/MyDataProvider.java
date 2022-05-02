package manager;

import models.Car;
import models.Car1;
import models.User;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyDataProvider {
    @DataProvider
    public Iterator<Object[]> dataLogin (){
        List<Object[]> list = new ArrayList<>();
        list.add (new Object[]{"noa@gmail.com","Nnoa12345$"});
        list.add (new Object[]{"noa@gmail.com","Nnoa12345$"});
        list.add (new Object[]{"sonya@gmail.com","Ss12345$"});

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> dataLoginCSV() throws IOException {
        List <Object[]> list = new ArrayList<>();

        BufferedReader reader=
                new BufferedReader(new FileReader(new File("src/test/resources/data.csv")));

        String line= reader.readLine();
        while (line!=null){
            String[] split = line.split(",") ;
            list.add(new Object[]{new User().withEmail(split[0]).withPassword(split[1])});
            line=reader.readLine();
        }

        return list.iterator();
    }


    @DataProvider
    public Iterator<Object[]> validDataCar() throws IOException {
        List<Object[]> list=new ArrayList<>();
        BufferedReader reader=new BufferedReader(new FileReader(new File("src/test/resources/car.csv")));
        String line=reader.readLine();

        while (line!=null){
            String[] split=line.split(";");
            list.add(new Object[]{Car.builder()
                    .address(split[0])
                    .make(split[1])
                    .model(split[2])
                    .year(split[3])
                    .engine(split[4])
                    .fuel(split[5])
                    .gear(split[6])
                    .wD(split[7])
                    .doors(split[8])
                    .seats(split[9])
                    .clasS(split[10])
                    .fuelConsumption(split[11])
                    .carRegNumber(split[12])
                    .price(split[13])
                    .distanceIncluded(split[14])
                    .features(split[15])
                    .about(split[16])
                    .build()});
            line = reader.readLine(); }



        return list.iterator();
    }


    @DataProvider
    public Iterator<Object[]> validDataCar1() throws IOException {
        List<Object[]> list=new ArrayList<>();
        BufferedReader reader=new BufferedReader(new FileReader(new File("src/test/resources/car.csv")));
        String line=reader.readLine();

        while (line!=null){
            String[] split=line.split(";");
            list.add(new Object[]{new Car1()
                    .withAddress(split[0])
                    .withMake(split[1])
                    .withModel(split[2])
                    .withYear(split[3])
                    .withEngine(split[4])
                    .withFuel(split[5])
                    .withGear(split[6])
                    .withwD(split[7])
                    .withDoors(split[8])
                    .withSeats(split[9])
                    .withClasS(split[10])
                    .withFuelConsumption(split[11])
                    .withCarRegNumber(split[12])
                    .withPrice(split[13])
                    .withDistanceIncluded(split[14])
                    .withFeatures(split[15])
                    .withAbout(split[16])});
            line = reader.readLine();
        }
        return list.iterator();
    }
}
