package tests;

import java.io.*;

public class modelGenerateService {
    public static void main(String[] args) {
//        List<String> listeClass = new ArrayList<>();
        String nomClass;

        // LISTE DES JPA
        File repertoire = new File("/prj-cens/Cens-Jpa/src/model");
        for (String az : repertoire.list()) {
            if (az.endsWith(".java") && !az.startsWith("Assoc")) {
                nomClass = az.substring(0, az.length() - 5);
//                listeClass.add(az.substring(0, az.length() - 5));
                System.out.println("==========TRAITEMENT CLASS : ===============");
                System.out.println(az.substring(0, az.length() - 5));


                //lecture du fichier pour le model
                String chaine = "";
                try {
                    InputStream ips = new FileInputStream("/prj-cens/Cens-Web/src/tests/modelGenerateModel.txt");
                    InputStreamReader ipsr = new InputStreamReader(ips);
                    BufferedReader br = new BufferedReader(ipsr);
                    String ligne;
                    while ((ligne = br.readLine()) != null) {
                        //System.out.println(ligne);
                        chaine += ligne + "\n";
                    }
                    br.close();
                } catch (Exception e) {
                    System.out.println(e.toString());
                }

                //MAJ NAME
                try {
                    chaine = chaine.replace("Xxx", nomClass);
                    chaine = chaine.replace("xxx", nomClass.toLowerCase());
                } catch (Exception e) {
                    e.printStackTrace();
                }

                //CREATION DU FICHIER
//                if (nomClass.equals("Bilan")) {


                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter(new File("/prj-cens/Cens-Ejb/ejbModule/service/" + nomClass + "Service.java")));
                    writer.write(chaine);
                    writer.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
//                }
            }

        }

    }
}