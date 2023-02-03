package Hierarcy;

import java.util.Scanner;
import java.util.logging.Logger;

public class Others {
        private int OtherId;
        private String OtherType;
        private  String OtherTitle;
        private String OtherAuthor;
        private int LibraryId;

        public Others(){};

        public Others(int OtherId, String OtherType, String OtherTitle, String OtherAuthor, int LibraryId){
            this.OtherId = OtherId;
            this.OtherType = OtherType;
            this.OtherTitle = OtherTitle;
            this.OtherAuthor = OtherAuthor;
            this.LibraryId = LibraryId;
        }

        public String getOtherType() {
            return OtherType;
        }

        public void setOtherType(String otherType) {
            this.OtherType = otherType;
        }

        public int getOtherId() {
            return OtherId;
        }

        public void setOtherId(int otherId) {
            this.OtherId = otherId;
        }
        public String getOtherTitle() {
            return OtherTitle;
        }

        public void setOtherTitle(String otherTitle) {
            this.OtherTitle = otherTitle;
        }
        public String getOtherAuthor() {
            return OtherAuthor;
        }

        public void setOtherAuthor(String otherAuthor) {
            this.OtherAuthor = otherAuthor;
        }
        public int getLibraryId() {
            return LibraryId;
        }

        public void setLibraryId(int libraryId) {
            this.LibraryId = libraryId;
        }

    public static Others Factory(Scanner scanner, Logger LOGGER){
        LOGGER.info("Enter other Id");
        int OtherId = scanner.nextInt();
        LOGGER.info("Enter type");
        String OtherType = scanner.next();
        LOGGER.info("Enter title");
        String OtherTitle = scanner.next();
        LOGGER.info("Enter author");
        String OtherAuthor = scanner.next();
        LOGGER.info("Enter libraryId");
        int LibraryId = scanner.nextInt();
        return new Others(OtherId, OtherType, OtherTitle, OtherAuthor, LibraryId);

    }
    @Override
    public String toString() {
        return " Others {" +
                ", OtherId = " + OtherId +
                ", OtherType = " + OtherType +
                ", OtherTitle = " + OtherTitle +
                ", OtherAuthor = " + OtherAuthor +
                ", LibraryId = " + LibraryId +
                '}';
    }
    }

