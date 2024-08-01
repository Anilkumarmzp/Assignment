package Beans;

import com.opencsv.exceptions.CsvException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.util.List;

public class CsvToMySQL {

    public static void main(String[] args) {
        String csvFilePath = "C:\\Users\\user\\Desktop\\AssignmentFile\\Data.csv";

        // Load Hibernate session factory
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            CsvReaderUtil csvReaderUtil = new CsvReaderUtil();
            List<String[]> csvData = csvReaderUtil.readCsv(csvFilePath);

            for (String[] row : csvData) {
                ClassEntity entity = new ClassEntity();
                entity.setColumn1(row[0]);
                entity.setColumn2(Integer.parseInt(row[1]));
                entity.setColumn3(row[2]);

                session.save(entity);
            }

            transaction.commit();
            System.out.println("CSV data has been inserted into the database.");
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        } finally {
            sessionFactory.close();
        }
    }
}
