public class PathReader {

    public String currentPath;

    public PathReader() {

    }

    public void readPath(String currentPath) {
        this.currentPath = currentPath;
        for (char c : currentPath.toCharArray()) {
            if (c == 'M') {

            }
            else if (c == 'L') {

            }
            else if (c == 'H') {

            }
            else if (c == 'V') {

            }
            else if (c == 'C') {

            }
            else if (c == 'S') {

            }
            else if (c == 'Q') {

            }
            else if (c == 'T') {

            }
            else if (c == 'A') {

            }
            else if (c == 'Z') {

            }
            // else ignore for now
        }
    }
}
