package testDB_1;

import java.io.*;
import java.sql.*;
 
public class SimpleTblExporter {
 
    public static void ExportGroupBy() {
        String csvFilePath = "Export.csv";
        String connectionUrl ="jdbc:sqlserver://DESKTOP-L2B00OG;database=CourseWork;";
        try (Connection connection = DriverManager.getConnection(connectionUrl,"Hr","Hr")) {
            String sql = "Select TypeID,AVG(Episodes) as \"AVG Episodes\" from AnimeTitles where TypeID IS NOT null group by TypeID ";

            Statement statement = connection.createStatement();
             
            ResultSet result = statement.executeQuery(sql);
             
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(csvFilePath));
             
            // write header line containing column names       
            fileWriter.write("TypeID,AVG Episodes");
             
            while (result.next()) {
                int TypeID = result.getInt("TypeID");
                int AVG_Episodes = result.getInt("AVG Episodes");
                 

                String line = String.format("%d,%d",
                         TypeID, AVG_Episodes);
                 
                fileWriter.newLine();
                fileWriter.write(line);            
            }
             
            statement.close();
            fileWriter.close();
             
        } catch (SQLException e) {
            System.out.println("Datababse error:");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("File IO error:");
            e.printStackTrace();
        }       
    }

    public static void ExportOrderBy() {
        String csvFilePath = "Export1.csv";
        String connectionUrl ="jdbc:sqlserver://DESKTOP-L2B00OG;database=CourseWork;";
        try (Connection connection = DriverManager.getConnection(connectionUrl,"Hr","Hr")) {
            String sql = "Select a.Name as \"AnimeName\",a.Rating,t.Name as \"TypeName\" from AnimeTitles a join Type t on t.TypeID=a.TypeID order by a.Rating";

            Statement statement = connection.createStatement();

            ResultSet result = statement.executeQuery(sql);

            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(csvFilePath));

            // write header line containing column names
            fileWriter.write("AnimeName,Rating,TypeName");

            while (result.next()) {
                String AnimeName=result.getString("AnimeName");
                int Rating = result.getInt("Rating");
                String TypeName = result.getString("TypeName");


                String line = String.format("%s,%d,%s",
                        AnimeName, Rating,TypeName);

                fileWriter.newLine();
                fileWriter.write(line);
            }

            statement.close();
            fileWriter.close();

        } catch (SQLException e) {
            System.out.println("Datababse error:");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("File IO error:");
            e.printStackTrace();
        }
    }

}

