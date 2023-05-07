package multimedia;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        divSpace divider = new divSpace();
        System.out.println("// - - - - // // Welcome to EpiPlayer \\\\ \\\\ - - - - //");
        System.out.println("");

        mediaElement[] mediaElements = new mediaElement[5];
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
        	String mediaType = null;
        	boolean validMediaType = false;
        	
        	while (!validMediaType) {
        		System.out.print("// Add a new Media (audio, video, image): ");
                mediaType = scanner.nextLine();
                
                if(mediaType.equalsIgnoreCase("audio") ||
                mediaType.equalsIgnoreCase("video") ||
                mediaType.equalsIgnoreCase("image") ||
                mediaType.equalsIgnoreCase("immagine")) {
                	validMediaType = true;
                } else {
                	System.out.println("// Unvalid Media Type. Press ENTER to continue.");
                }
        	}
        	  
            System.out.print("// Add Title: ");
            String title = scanner.nextLine();

            int duration = 0;
            int brightness = 0;
            
            
            // Se di tipo audio o video, aggiungi Duration
            if (mediaType.equalsIgnoreCase("audio") || mediaType.equalsIgnoreCase("video")) {
                System.out.print("// Add Duration(0-9): ");
                while (true) {
                    while (!scanner.hasNextInt()) {
                        System.out.println("// Invalid. Please use 0-9:");
                        scanner.nextLine();
                    }
                    duration = scanner.nextInt();
                    if (duration >= 0 && duration <= 9) {
                        break;
                    } else {
                        System.out.println("// Invalid. Please use 0-9:");
                        scanner.nextLine();
                    }
                }
            }

            // Se di tipo immagine o video, aggiungi Brightness
            if (mediaType.equalsIgnoreCase("image") || mediaType.equalsIgnoreCase("video")) {
            	System.out.print("// Add Brightness(0-9): ");
                while (true) {
                    while (!scanner.hasNextInt()) {
                        System.out.println("// Invalid. Please use 0-9:");
                        scanner.nextLine();
                    }
                    brightness = scanner.nextInt();
                    if (brightness >= 0 && brightness <= 9) {
                        break;
                    } else {
                        System.out.println("// Invalid. Please use 0-9:");
                        scanner.nextLine();
                    }
                }
            }

            
            // Controllo ortografico
         
// Prima versione di controllo nella creazione oggetto, sostituita con if-else per 
// utilizzare IgnoreCase
//            switch (mediaType) {
//                case "audio", "AUDIO", "Audio", "aUDIO" :
//                    mediaElements[i] = new audio(title, duration);
//                	System.out.println("// Media addedd succesfully.");
//                    break;
//                case "video", "VIDEO", "Video", "vIDEO":
//                    mediaElements[i] = new video(title, duration, brightness);
//                    break;
//                case "image", "IMAGE", "Image", "iMAGE", "immagine", "IMMAGINE", "Immagine", "iMMAGINE":
//                    mediaElements[i] = new image(title, brightness);
//                    break;
//                default:
//                    System.out.println("// Unvalid Media Type. Press ENTER to continue.");
//                    i--;
//            }
            
            if (mediaType.equalsIgnoreCase("audio")) {
                mediaElements[i] = new audio(title, duration);
                System.out.println("// Media addedd succesfully.");
                System.out.println("");
            } else if (mediaType.equalsIgnoreCase("video")) {
                mediaElements[i] = new video(title, duration, brightness);
                System.out.println("// Media addedd succesfully.");
                System.out.println("");
            } else if (mediaType.equalsIgnoreCase("image") || mediaType.equalsIgnoreCase("immagine")) {
                mediaElements[i] = new image(title, brightness);
                System.out.println("// Media addedd succesfully.");
                System.out.println("");
            } else {
                System.out.println("// Unvalid Media Type. Press ENTER to continue.");
                System.out.println("");
                i--; // Ripete l'iterazione corrente, riportando indietro l'indice, finchè la risposta non viene accettata
            }

            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }
        }

        int selectedIndex;
        boolean printMediaList = true;

        do {
            if (printMediaList && mediaElements.length >= 5) {
                System.out.println("// Your stuff :");
                for (int i = 0; i < mediaElements.length; i++) {
                    mediaElement element = mediaElements[i];
                    System.out.println("// " + (i + 1) + ". " + element.getTitle() + " (" + element.getClass().getSimpleName() + ")");
                }
            }
            printMediaList = true; // Imposta printMediaList a true per stampare la lista nel prossimo ciclo
            
            System.out.print("// Enter the index of the media item to play (1-5) or 0 to exit:");
            
            selectedIndex = scanner.nextInt();
            

            if (selectedIndex >= 1 && selectedIndex <= 5) {
                mediaElement selectedMedia = mediaElements[selectedIndex - 1];

                System.out.println("// 1. Play");
                System.out.println("// 2. Modify Volume (Videos and Audios)");
                System.out.println("// 3. Modifiy Brightness (Videos and Images");
                System.out.print("// Choose an option:");
                int option = scanner.nextInt();
                scanner.nextLine();

                switch (option) {
                    case 1:
                        if (selectedMedia instanceof audio) {
                            ((audio) selectedMedia).playAudio();
                        } else if (selectedMedia instanceof video) {
                            ((video) selectedMedia).playVideo();
                        } else if (selectedMedia instanceof image) {
                            ((image) selectedMedia).show();
                        }
                        System.out.println("// Press ENTER to go back:");
                        scanner.nextLine();
                        break;
                    case 2:
                        if (selectedMedia instanceof volumeInterface) {
                            System.out.println("// Add new Volume value:");
                            int newVolume = scanner.nextInt();
                            ((volumeInterface) selectedMedia).setVolume(newVolume);
                        } else {
                            System.out.println("// This Media does not support audio.");
                        }
                        break;
                    case 3:
                        if (selectedMedia instanceof brightnessInterface) {
                            System.out.println("// Add new Brightness:");
                            int newBrightness = scanner.nextInt();
                            ((brightnessInterface) selectedMedia).setBrightness(newBrightness);
                        } else {
                            System.out.println("// This Media does not support brightness.");
                        }
                        break;
                    default:
                        System.out.println("// Invalid option. Please choose again.");
                }
                divider.placeDiv();
            } else if (selectedIndex != 0) {
                System.out.println("// Invalid Index.");
            }
        } while (selectedIndex != 0);

        scanner.close();
        System.out.println("// Have a nice day!");
    }
}