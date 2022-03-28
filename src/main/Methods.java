package main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.Collections;
import java.util.Scanner;

public class Methods {
    private Statement s = null;
    private Connection conn = null;
    private ResultSet RS = null;
    Scanner sc = new Scanner(System.in);
    Scannerclass be = new Scannerclass();

    public void Insert() {
        SM("Mely táblába szeretne felvinni uj adatokat? \n 1.Örömlány \n 2.Vásárló" );
        int i = sc.nextInt();
        switch (i) {
            case 1:
                String sqlp= "insert into Oromlany(Id,Nev,Szulido,Szulhely,Szepsegindex,Vakumhatas) values(?,?,?,?,?,?)";
                try {
                    PreparedStatement ps = conn.prepareStatement(sqlp);
                    SM("Kérem a személy id-jét: ");
                    ps.setInt(1, sc.nextInt());
                    SM("Kérem a Nevet: ");
                    ps.setString(2, sc.next());
                    SM("Kérem a szuletési idejét: ");
                    ps.setString(3, sc.next());
                    SM("Kérem a Születésihelyét: ");
                    ps.setString(4,sc.next());
                    SM("Kérem a Szépség indexét: ");
                    ps.setInt(5,sc.nextInt());
                    SM("Kérem a vakumhatás nagyságát: ");
                    ps.setInt(6,sc.nextInt());
                    ps.execute();
                } catch (Exception e) {SM(e.getMessage());
                }
                SM("Örömlány tábla bővűlt:");
                PrintAllDataOromlanytable();
                break;

            case 2:
                String sqlp2= "insert into Vasarlo(Id,Nev,Szulido,Szulhely,Fizetesimod,oromlanyid) values(?,?,?,?,?,?)";
                try {
                    PreparedStatement ps = conn.prepareStatement(sqlp2);
                    SM("Kérem az Id-t: ");
                    ps.setInt(1, sc.nextInt());
                    SM("Kérem a nevét: ");
                    ps.setString(2, sc.next());
                    SM("Kérem a születési idejét: ");
                    ps.setString(3,sc.next());
                    SM("Kérem a születési helyét: ");
                    ps.setString(4,sc.next());
                    SM("Kérem a fizetési módot: ");
                    ps.setString(5,sc.next());
                    SM("Kérem az Örömlány id-jét: ");
                    ps.setString(6,sc.next());
                    ps.execute();
                } catch (Exception e) {SM(e.getMessage());
                }
                SM("Vásárló tábla bővült:");
                PrintAllDataVasarloTable();
                break;

            default:
                System.out.println("Nincs ilyen tábla!");
                break;
        }

    }

    public void PrintAllDataOromlanytable() {
        String nev ="", szulido="", szulhely="", x="\t";
        int id=0, szepsegIndex=0, vakumHatas=0;
        String sqlp= "select id,nev,szulido,szulhely,szepsegIndex,vakumHatas from Oromlany";
        try {
            s =  conn.createStatement();
            RS = s.executeQuery(sqlp);
            while(RS.next()) {
                id = RS.getInt("Id");
                nev = RS.getString("Nev");
                szulido = RS.getString("Szulido");
                szulhely = RS.getString("Szulhely");
                szepsegIndex= RS.getInt("Szepsegindex");
                vakumHatas= RS.getInt("Vakumhatas");
                SM(id+x+nev+x+szulido+x+szulhely+x+szepsegIndex+x+vakumHatas);
            }
            RS.close();
        } catch (SQLException e) {SM(e.getMessage());}
    }
    public void PrintAllDataVasarloTable() {
        String nev="", szulido="", szulhely="", fizetesiMod="", x="\t";
        int id =0,oromlanyid=0;
        String sqlp= "select Id,Szulhely,Nev,Szulido,Fizetesimod,oromlanyid from Vasarlo";
        try {
            s =  conn.createStatement();
            RS = s.executeQuery(sqlp);
            while(RS.next()) {
                id= RS.getInt("Id");
                oromlanyid = RS.getInt("oromlanyid");
                nev = RS.getString("Nev");
                szulido = RS.getString("Szulido");
                szulhely = RS.getString("Szulhely");
                fizetesiMod = RS.getString("Fizetesimod");
                SM(id+x+nev+x+szulido+x+szulhely+x+szulido+x+fizetesiMod+x+oromlanyid);
            }
            RS.close();
        } catch (SQLException e) {SM(e.getMessage());}
    }

    public void Print() {
        SM("Mely tábla adatait szeretné megtekeinteni? \n 1.Örömlányok \n 2.Vásárlók");
        int table = sc.nextInt();
        SM("Mely sorára kíváncsi?");
        String adat ="";
        int adat2 = 0;
        String sqlp = new String();
        switch (table) {
            case 1:
                SM("\n 1.Id \n 2.Nev \n 3.Szulido \n 4.Szulhely \n 5.Szepsegindex \n 6.Vakumhatas");
                int i = sc.nextInt();
                switch (i) {
                    case 1:
                        try {
                            sqlp= "select Id from Oromlany";
                            s =  conn.createStatement();
                            RS = s.executeQuery(sqlp);
                            while(RS.next()) {
                                adat2 = RS.getInt("Id");
                                System.out.println(adat2);
                            }
                            RS.close();
                        } catch (SQLException e) {SM(e.getMessage());}

                        break;
                    case 2:
                        try {
                            sqlp= "select Nev from Oromlany";
                            s =  conn.createStatement();
                            RS = s.executeQuery(sqlp);
                            while(RS.next()) {
                                adat = RS.getString("Nev");
                                System.out.println(adat);
                            }
                            RS.close();
                        } catch (SQLException e) {SM(e.getMessage());}

                        break;
                    case 3:
                        try {
                            sqlp= "select Szulido from Oromlany";
                            s =  conn.createStatement();
                            RS = s.executeQuery(sqlp);
                            while(RS.next()) {
                                adat = RS.getString("Szulido");
                                System.out.println(adat);
                            }
                            RS.close();
                        } catch (SQLException e) {SM(e.getMessage());}

                        break;
                    case 4:
                        try {
                            sqlp= "select Szulhely from Oromlany";
                            s =  conn.createStatement();
                            RS = s.executeQuery(sqlp);
                            while(RS.next()) {
                                adat = RS.getString("Szulhely");
                                System.out.println(adat);
                            }
                            RS.close();
                        } catch (SQLException e) {SM(e.getMessage());}

                        break;
                    case 5:
                        try {
                            sqlp= "select Szepsegindex from Oromlany";
                            s =  conn.createStatement();
                            RS = s.executeQuery(sqlp);
                            while(RS.next()) {
                                adat2= RS.getInt("Szepsegindex");
                                System.out.println(adat2);
                            }
                            RS.close();
                        } catch (SQLException e) {SM(e.getMessage());}

                        break;
                    case 6:
                        try {
                            sqlp= "select Vakumhatas from Oromlany";
                            s =  conn.createStatement();
                            RS = s.executeQuery(sqlp);
                            while(RS.next()) {
                                adat2 = RS.getInt("Vakumhatas");
                                System.out.println(adat2);
                            }
                            RS.close();
                        } catch (SQLException e) {SM(e.getMessage());}

                        break;

                };
                break;
            case 2:
                SM("\n 1.Id \n 2.Nev \n 3.Szulido \n 4.Szulhely \n 5.Fizetesimod \n 6.oromlanyid");
                int j = sc.nextInt();
                switch (j) {
                    case 1:
                        try {
                            sqlp= "select Id from Vasarlo";
                            s =  conn.createStatement();
                            RS = s.executeQuery(sqlp);
                            while(RS.next()) {
                                adat = RS.getString("Id");
                                System.out.println(adat);
                            }
                            RS.close();
                        } catch (SQLException e) {SM(e.getMessage());}

                        break;
                    case 2:
                        try {
                            sqlp= "select Nev from Vasarlo";
                            s =  conn.createStatement();
                            RS = s.executeQuery(sqlp);
                            while(RS.next()) {
                                adat = RS.getString("Nev");
                                System.out.println(adat);
                            }
                            RS.close();
                        } catch (SQLException e) {SM(e.getMessage());}

                        break;
                    case 3:
                        try {
                            sqlp= "select Szulido from Vasarlo";
                            s =  conn.createStatement();
                            RS = s.executeQuery(sqlp);
                            while(RS.next()) {
                                adat = RS.getString("Szulido");
                                System.out.println(adat);
                            }
                            RS.close();
                        } catch (SQLException e) {SM(e.getMessage());}

                        break;
                    case 4:
                        try {
                            sqlp= "select Szulhely from Vasarlo";
                            s =  conn.createStatement();
                            RS = s.executeQuery(sqlp);
                            while(RS.next()) {
                                adat = RS.getString("Szulhely");
                                System.out.println(adat);
                            }
                            RS.close();
                        } catch (SQLException e) {SM(e.getMessage());}

                        break;
                    case 5:
                        try {
                            sqlp= "select Fizetesimod from Vasarlo";
                            s =  conn.createStatement();
                            RS = s.executeQuery(sqlp);
                            while(RS.next()) {
                                adat = RS.getString("Fizetesimod");
                                System.out.println(adat);
                            }
                            RS.close();
                        } catch (SQLException e) {SM(e.getMessage());}

                        break;
                    case 6:
                        try {
                            sqlp= "select oromlanyid from Vasarlo";
                            s =  conn.createStatement();
                            RS = s.executeQuery(sqlp);
                            while(RS.next()) {
                                adat2 = RS.getInt("oromlanyid");
                                System.out.println(adat2);
                            }
                            RS.close();
                        } catch (SQLException e) {SM(e.getMessage());}

                        break;
                    default:
                        SM("Nincs ilyen lehetőség!");
                        break;
                }
        }
    }


    public int Bejelentkezésmetod(String name, String pswd) {
        int pc= -1;
        String sqlq = "select count(*) pc from user where name='"+name+"' and pswd='"+pswd+ "';";
        try {
            s = conn.createStatement();
            RS= s.executeQuery(sqlq);
            while(RS.next()) {
                pc= RS.getInt("pc");
            }
        } catch (SQLException e) {
            SM(e.getMessage());
        }
        return pc;
    }

    public void Bejelent(String name, String psw) {
        int pc = Bejelentkezésmetod(name, psw);
        if (pc==1) {
            SM("Sikeres bejelentkezés!");
        }else {
            SM("Ilyen felhasználó név nem található/rossz a jelszó!");
            System.exit(0);
        }
    }

    public void Delete() {
        SM("Melyik táblából szeretne törölni? \n 1.Örömlány \n 2.Vásárló");
        String i = sc.next();
        switch (i) {
            case "1":
                SM("Törlendő Örömlány sorszáma: ");
                String sorszam = sc.next();
                String sqlp = "delete from Oromlany where id like '" + sorszam + "'";
                if (conn != null) {
                    try { s = conn.createStatement();
                        s.executeUpdate(sqlp);
                        s.close();
                        SM(sorszam + "Örömlány törölve\n");
                    } catch (Exception ex)
                    {System.err.println(ex.getMessage());
                    }
                }
                break;

            case "2":
                SM("Törlendő Vásárló id-jét: ");
                String id = sc.next();
                String sqlp2 = "delete from Vasarlo where Id like '" + id + "'";
                if (conn != null) {
                    try { s = conn.createStatement();
                        s.executeUpdate(sqlp2);
                        s.close();
                        System.out.println(id + "Vásárló törölve\n");
                    } catch (Exception ex)
                    {System.err.println(ex.getMessage());
                    }
                }
                break;

            default:
                SM("Nincs ilyen tábla!");
        }


    }
    public void Change() {
        SM("Melyik táblában szeretne Módosítani? \n 1.Örömlány 2.Vásárló");
        int i = sc.nextInt();
        switch (i) {
            case 1:
                SM("írja be az örömlány nevét melyen módosítani szeretne : ");
                String nev = sc.next();
                SM("Mit szeretne módosítani? \n 1.Id \n 2.Név \n 3.Születésiidő \n 4. Születésihely \n 5.SzépségiIndex \n 6.Vakumhatás");
                int me= sc.nextInt();
                String sqlp = "";
                String ujadat = new String();
                switch(me) {
                    case 1:
                        SM("Mire szeretné átírni?");
                        ujadat =sc.next();
                        sqlp = "Update Oromlany set Id='" + ujadat + "'"  + " where Nev like '" + nev + "'";
                        break;
                    case 2:
                        SM("Mire szeretné átírni?");
                        ujadat =sc.next();
                        sqlp = "Update Oromlany set Nev='" + ujadat + "'"  + " where Nev like '" + nev + "'";
                        break;
                    case 3:
                        SM("Mire szeretné átírni?");
                        ujadat =sc.next();
                        sqlp = "Update Oromlany set Szulido='" + ujadat + "'"  + " where Nev like '" + nev + "'";
                        break;
                    case 4:
                        SM("Mire szeretné átírni?");
                        ujadat =sc.next();
                        sqlp = "Update Oromlany set Szulhely='" + ujadat + "'"  + " where Nev like '" + nev + "'";
                        break;
                    case 5:
                        SM("Mire szeretné átírni?");
                        ujadat =sc.next();
                        sqlp = "Update Oromlany set Szepsegindex='" + ujadat + "'"  + " where Nev like '" + nev + "'";
                        break;
                    case 6:
                        SM("Mire szeretné átírni?");
                        ujadat =sc.next();
                        sqlp = "Update Oromlany set Vakumhatas='" + ujadat + "'"  + " where Nev like '" + nev + "'";
                        break;
                }
                if (me > 0 && me <7	) {
                    if (conn != null) {
                        try { s = conn.createStatement();
                            s.executeUpdate(sqlp);
                            s.close();
                            System.out.println(nev + "  módósítva lett\n");
                        } catch (Exception ex)
                        {System.err.println(ex.getMessage());
                        }
                    }}else {
                    System.out.println("Semmi nem lett módosítva");
                }
                break;
            case 2:
                SM("írja be a személy id-jét akinek az adatait módosítani szeretne : ");
                String id= sc.next();
                SM("Mit szeretne módosítani? \n 1.Id \n 2.Név \n 3.Születésiidő \n 4.Születésihely \n 5.Fizetésimód \n 6.Örömlányid ");
                int me2= sc.nextInt();
                String sqlp2 = "";
                ;			String ujadat2 = new String();
                switch(me2) {
                    case 1:
                        SM("Mire szeretné átírni?");
                        ujadat2 =sc.next();
                        sqlp2 = "Update Vasarlo set Id='" + ujadat2 + "'"  + " where Id like '" + id + "'";

                        break;
                    case 2:
                        SM("Mire szeretné átírni?");
                        ujadat2 =sc.next();
                        sqlp2 = "Update Vasarlo set Nev='" + ujadat2 + "'"  + " where Id like '" + id + "'";
                        break;
                    case 3:
                        SM("Mire szeretné átírni?");
                        ujadat2 =sc.next();
                        sqlp2 = "Update Vasarlo set Szulido='" + ujadat2 + "'"  + " where Id like '" + id + "'";
                        break;
                    case 4:
                        SM("Mire szeretné átírni?");
                        ujadat2 =sc.next();
                        sqlp2 = "Update Vasarlo set Szulhely='" + ujadat2 + "'"  + " where Id like '" + id + "'";
                        break;
                    case 5:
                        SM("Mire szeretné átírni?");
                        ujadat2 =sc.next();
                        sqlp2 = "Update Vasarlo set Fizetesimod='" + ujadat2 + "'"  + " where Id like '" + id + "'";
                        break;
                    case 6:
                        SM("Mire szeretné átírni?");
                        ujadat2 =sc.next();
                        sqlp2 = "Update Vasarlo set oromlanyid='" + ujadat2 + "'"  + " where Id like '" + id + "'";
                        break;
                }
                if (me2 > 0 && me2 <7	) {
                    if (conn != null) {
                        try { s = conn.createStatement();
                            s.executeUpdate(sqlp2);
                            s.close();
                            System.out.println(id + "  módósítva lett\n");
                        } catch (Exception ex)
                        {System.err.println(ex.getMessage());
                        }
                    }}else {
                    System.out.println("Semmi nem lett módosítva");
                }
                break;
        }

    }
    public void Connect() {
        try {
            String url = "jdbc:sqlite:C:/Users/User-Pc/Documents/GitHub/Kadar_Konrad_JDBC_felevesfeladat/kadar jdbc/bordelyhaz.db";
            conn = DriverManager.getConnection(url);
            SM("Connection ok!");
        }catch (SQLException e) {
            SM("JDBC Connect:" +e.getMessage());
        }

    }

    public void DisConnect() {
        try {
            conn.close();
            SM("Disconnection ok!");
        } catch (SQLException e) {SM(e.getMessage());}
    }

    public void Reg() {
        try {
            Class.forName("org.sqlite.JDBC");
            SM("Sikeres driver regisztráció!");
        }catch (ClassNotFoundException e) {
            SM("hibás driver regisztráció!");
        }

    }
    public void menu(){
        Reg();
        Connect();
        System.out.println("Bejelentkezés: ");
        String name = be.ReadData("Kérem a felhasználónevet: ");
        String psw = be.ReadData("Kérem a jelszót: ");
        Bejelentkezésmetod(name, psw);
        Bejelent(name, psw);
        while (1!=0) {
            SM("Hello " + name + " ! Mit szeretnél csinálni? \n 1.Örömlány tábla megtekintése \n 2.Vásárló tábla megtekintése "
                    + "\n 3.Egy tábla egy sorának megtekintése \n 4.Új adatok felvitele \n 5.Törlés \n 6.Adatok módosítása \n 7.Driveradatok lekérése \n 8.Tábla adatok lekérése \n 9.tábla adat mentése \n 0.Kilépés");
            int i = sc.nextInt();
            switch (i) {
                case 0:
                    SM("Viszlát " + name +" !");
                    DisConnect();
                    System.exit(0);
                    break;
                case 1:
                    PrintAllDataOromlanytable();
                    break;
                case 2:
                    PrintAllDataVasarloTable();
                    break;
                case 3:
                    Print();
                    break;
                case 4:
                    Insert();
                    break;
                case 5:
                    Delete();
                    break;
                case 6:
                    Change();
                    break;
                case  7:
                    jdbcDriverquery();
                    break;
                case 8:
                    metaDataTableQuery();
                    break;
                case 9:
                    exportdb();
                    break;
                default:
                    System.out.println("Nincs ilyen opció!");
            }
        }
    }

    private void exportdb() {
        SM("Mely táblát szeretnéd lementeni csv-be? \n 1.Örömlány \n 2.Vásárló" );
        int i = sc.nextInt();
        switch (i) {
            case 1:
                exportdbOromlany();
                break;
            case 2:
               exportdbVasarlo();
                break;
            default:
                System.out.println("Nincs ilyen tábla!");
                break;
        }
    }

    private void metaDataTableQuery(){
        String catalog= null;
        String columnNamePattern=null;
        String schemaPattern=null;

        SM("Mely táblának szeretnéd lekérni a metaadatát? \n 1.Örömlány \n 2.Vásárló" );
        int i = sc.nextInt();
        switch (i) {
            case 1:
                try {
                    DatabaseMetaData databaseMetaData = conn.getMetaData();
                    RS=databaseMetaData.getColumns(catalog,schemaPattern,"Oromlany",columnNamePattern);
                    SM( "Örömlány oszlopai ");
                    while (RS.next()) {
                        System.out.println(RS.getString("COLUMN_NAME"));
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                try {
                    DatabaseMetaData databaseMetaData = conn.getMetaData();
                    RS=databaseMetaData.getColumns(catalog,schemaPattern,"Vasarlo",columnNamePattern);
                    SM( "Vásárló oszlopai ");
                    while (RS.next()) {
                        System.out.println(RS.getString("COLUMN_NAME"));
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;

            default:
                System.out.println("Nincs ilyen tábla!");
                break;
        }
    }

    private void jdbcDriverquery(){

        try {
            DatabaseMetaData databaseMetaData = conn.getMetaData();

            System.out.println("JDBC Driver Name " + databaseMetaData.getDriverName());
            System.out.println("JDBC Driver version " + databaseMetaData.getDriverVersion());
            System.out.println("JDBC MajorVersion " + databaseMetaData.getDriverMajorVersion());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void exportdbOromlany(){
        String csvFilePath = "oromlany.csv";
        String nev ="", szulido="", szulhely="", x="\t";
        int id=0, szepsegIndex=0, vakumHatas=0;
        try {
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(csvFilePath));

            // write header line containing column names
            fileWriter.write("Id,Név,Születésidő,Születésihely,SzépségIndex,Vákumhatás");
            String sqlp= "select id,nev,szulido,szulhely,szepsegIndex,vakumHatas from Oromlany";

            s =  conn.createStatement();
            RS = s.executeQuery(sqlp);
            while(RS.next()) {
                id = RS.getInt("Id");
                nev = RS.getString("Nev");
                szulido = RS.getString("Szulido");
                szulhely = RS.getString("Szulhely");
                szepsegIndex= RS.getInt("Szepsegindex");
                vakumHatas= RS.getInt("Vakumhatas");
                SM(id+x+nev+x+szulido+x+szulhely+x+szepsegIndex+x+vakumHatas);
                fileWriter.newLine();
                String line = String.format("%s, %s,%s,%s,%s,%s",
                        id,nev, szulido, szulhely, szepsegIndex, vakumHatas);
                fileWriter.write(line);
            }
            s.close();
            fileWriter.close();
            RS.close();
        } catch (SQLException e ) {SM(e.getMessage());}
        catch (IOException e ) {SM(e.getMessage());}
    }

    private void exportdbVasarlo(){
        String nev="", szulido="", szulhely="", fizetesiMod="", x="\t";
        int id =0,oromlanyid=0;

        String csvFilePath = "Vasarlo.csv";
        try {
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(csvFilePath));

            // write header line containing column names
            fileWriter.write("Id,Név,Születésidő,Születésihely,Fizetesimod,Örömlányid");
            String sqlp= "select Id,Szulhely,Nev,Szulido,Fizetesimod,oromlanyid from Vasarlo";

            s =  conn.createStatement();
            RS = s.executeQuery(sqlp);
            while(RS.next()) {
                id= RS.getInt("Id");
                oromlanyid = RS.getInt("oromlanyid");
                nev = RS.getString("Nev");
                szulido = RS.getString("Szulido");
                szulhely = RS.getString("Szulhely");
                fizetesiMod = RS.getString("Fizetesimod");
                SM(id+x+nev+x+szulido+x+szulhely+x+szulido+x+fizetesiMod+x+oromlanyid);
                fileWriter.newLine();
                String line = String.format("%s,%s,%s,%s,%s,%s",
                        id,nev, szulido, szulhely, fizetesiMod, oromlanyid);
                fileWriter.write(line);
            }
            s.close();
            fileWriter.close();
            RS.close();
        } catch (SQLException e ) {SM(e.getMessage());}
        catch (IOException e ) {SM(e.getMessage());}
    }

    public void SM(String msg){
        System.out.println(msg);
    }

}
