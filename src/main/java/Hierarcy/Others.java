package src.main.java.Hierarcy;

public class Others {
        private int OtherId;
        private String OtherType;
        private  String OtherTitle;
        private String OtherAuthor;
        private int LibraryId;

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
    }

