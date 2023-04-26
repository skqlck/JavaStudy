package 메모장프로그램;

class UserSolution
{
    int HEIGHT;
    int WIDTH;
    Node START;
    int SIZE;
    Node CURSOR;
    Node END; // END의 IDX는 SIZE, 빈 노드 (오른쪽에 문자 X)
    int IDX; // 커서 인덱스 moveCursor에서 사용 (앞으로 갈지 뒤로 갈지)
    void init(int H, int W, char mStr[])
    {
        HEIGHT = H;
        WIDTH = W;
        SIZE = mStr.length;
        START = new Node();
        START.value = mStr[0];
        Node now = START;
        for (int i=1; i<SIZE; i++){
            Node newNode = new Node();
            now.tail = newNode;
            newNode.value = mStr[i];
            newNode.head = now;
            now = newNode;
        }
        END = new Node();
        END.head = now;
        END.value = '$';
        now.tail = END;
        CURSOR = START;
        IDX = 0;
    }
    void insert(char mChar)
    { // 새로운 노드를 삽입하고 커서를 한칸 오른쪽으로 옮길것
        Node newNode = new Node();
        newNode.value = mChar;
        if (CURSOR.head == null){
            // 커서가 1,1에 있는 상황, idx = 0
            CURSOR.head = newNode;
            newNode.tail = CURSOR;
            START = newNode;
        }
        else {
            CURSOR.head.tail = newNode;
            newNode.head = CURSOR.head;
            CURSOR.head = newNode;
            newNode.tail = CURSOR;
        }
        SIZE ++;
        IDX ++;
    }

    char moveCursor(int mRow, int mCol)
    {   // START, CURSOR, END 중 newIDX에서 가장 가까운 곳에서 출발
        // 인덱스를 벗어나면 END 노드로
        int newIDX = HEIGHT*(mRow-1)+(mCol-1);
        if (newIDX > SIZE-1){
            CURSOR= END;
        }
        // START에서 가장 가까운 경우
        else if (newIDX <= abs(IDX-newIDX) && newIDX <= abs(SIZE-newIDX)){
            int idx = 0;
            Node now = START;
            while (idx != newIDX){
                now = now.tail;
                idx += 1;
            }
            CURSOR = now;
            IDX = newIDX;
        }
        // CURSOR에서 가장 가까운 경우
        else if (abs(IDX-newIDX) <= newIDX && abs(IDX-newIDX) <= (SIZE-newIDX)){
            int idx = IDX;
            Node now = CURSOR;
            if (idx <= newIDX){
                while (idx != newIDX){
                    now = now.tail;
                    idx += 1;
                }
                CURSOR = now;
            }
            else {
                while (idx != newIDX) {
                    now = now.head;
                    idx -= 1;
                }
                CURSOR = now;
                IDX = newIDX;
            }
        }
        // END에서 가장 가까운 경우
        else{
            int idx = SIZE;
            Node now = END;
            while (idx != newIDX){
                now = now.head;
                idx -= 1;
            }
            CURSOR = now;
            IDX = newIDX;
        }
        return CURSOR.value;
    }

    int countCharacter(char mChar)
    {
        int cnt = 0;
        Node now = CURSOR;
        while (now != END){
            if (now.value == mChar){
                cnt++;
            }
            now = now.tail;
        }
        return cnt;
    }

    int abs(int number){
        if (number < 0){
            return -number;
        }
        return number;
    }
}

class Node{
    Node head;
    Node tail;
    char value;
}