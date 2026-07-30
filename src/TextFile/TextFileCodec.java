package TextFile;

 class TextFileCodec {

    public TextFileCodec() {
    }

    static String encode(String value) {

        if (value == null) {
            return "";
        }

        return value
                .replace("%", "%25")
                .replace("|", "%7C")
                .replace("\r", "%0D")
                .replace("\n", "%0A");
    }

    static String decode(String value) {

        if (value == null) {
            return "";
        }

        return value
                .replace("%0A", "\n")
                .replace("%0D", "\r")
                .replace("%7C", "|")
                .replace("%25", "%");
    }
}