package 동선추적;

class UserSolution {

    void init() {

    }

    void addPlace(int pID, int r, int c) {

    }

    void removePlace(int pID) {

    }

    void contactTracing(int uID, int visitNum, int moveInfo[], int visitList[]) {

    }

    void disinfectPlaces(int uID) {

    }
}

class Place{
    int pID = 0;
    int x;
    int y;
    boolean visitable = true;
    Place[] nearPlaces = new Place[7];
}