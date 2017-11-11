#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int main(int argc, const char * argv[]) {
    vector<string> x;
    string str;
    int n;
    cin >> n;
    for (int i = 0; i < n; i ++) {
        cin >> str;
        x.push_back(str);
    }
    for (int i = 0; i < n; i++) {
        bool value = next_permutation(x[i].begin(), x[i].end());
        if (!value) {
            cout << "no answer" << endl;
            continue;
        }
        cout << x[i] << endl;
    }
    return 0;
}
