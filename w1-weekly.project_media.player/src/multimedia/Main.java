package multimedia;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        divSpace divider = new divSpace();

        mediaElement[] mediaElements = new mediaElement[5];
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            System.out.println("Add a new Media (audio, video, image):");
            String mediaType = scanner.nextLine();

            System.out.println("Add the Title:");
            String title = scanner.nextLine();

            int duration = 0;
            int brightness = 0;
            if (mediaType.equals("audio") || mediaType.equals("video")) {
                System.out.println("Add Duration:");
                duration = scanner.nextInt();
            }

            if (mediaType.equals("image") || mediaType.equals("video")) {
                System.out.println("Add Brightness:");
                brightness = scanner.nextInt();
            }

            switch (mediaType) {
                case "audio", "AUDIO", "Audio", "aUDIO" :
                    mediaElements[i] = new audio(title, duration);
                    break;
                case "video", "VIDEO", "Video", "vIDEO":
                    mediaElements[i] = new video(title, duration, brightness);
                    break;
                case "image", "IMAGE", "Image", "iMAGE":
                    mediaElements[i] = new image(title, brightness);
                    break;
                default:
                    System.out.println("Unvalid Media Type. Press ENTER to continue.");
                    i--; // Ripeti l'iterazione corrente finchè la risposta non va bene.
            }

            if (scanner.hasNextLine()) {
                scanner.nextLine(); // Pulisci il buffer (me l'ha detto google)
            }
        }

        int selectedIndex;
        do {
            System.out.println("Enter the index of the media item to play (1-5) or 0 to exit:");
            selectedIndex = scanner.nextInt();

            if (selectedIndex >= 1 && selectedIndex <= 5) {
                mediaElement selectedMedia = mediaElements[selectedIndex - 1];

                System.out.println("Choose an option:");
                System.out.println("1. Play");
                System.out.println("2. Modify Volume (Only for Audios and Videos)");
                System.out.println("3. Modifiy Brightness (Only for Videos and Images");
                int option = scanner.nextInt();

                switch (option) {
                    case 1:
                        if (selectedMedia instanceof audio) {
                            ((audio) selectedMedia).playAudio();
                        } else if (selectedMedia instanceof video) {
                            ((video) selectedMedia).playVideo();
                        } else if (selectedMedia instanceof image) {
                            ((image) selectedMedia).show();
                        }
                        break;
                    case 2:
                        if (selectedMedia instanceof volumeInterface) {
                            System.out.println("Add new Volume value:");
                            int newVolume = scanner.nextInt();
                            ((volumeInterface) selectedMedia).setVolume(newVolume);
                        } else {
                            System.out.println("This Media does not support audio.");
                        }
                        break;
                    case 3:
                        if (selectedMedia instanceof brightnessInterface) {
                            System.out.println("Add new Brightness:");
                            int newBrightness = scanner.nextInt();
                            ((brightnessInterface) selectedMedia).setBrightness(newBrightness);
                        } else {
                            System.out.println("This Media does not support brightness.");
                        }
                        break;
                    default:
                        System.out.println("Invalid option. Please choose again.");
                }
                divider.placeDiv();
            } else if (selectedIndex != 0) {
                System.out.println("Invalid Index.");
            }
        } while (selectedIndex != 0);

        scanner.close();
    }
}