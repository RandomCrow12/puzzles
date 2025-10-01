#include <iostream>
#include <vector>
#include <string>
#define ll long long

using namespace std;

ll eval(const vector<char>& nums, const vector<char>& ops) { // odd but strong implemntation ig
    vector<ll> values;
    values.push_back(nums[0] - '0'); // somehow converts the char to a number, wild and unreadable
    for (size_t i = 0; i < ops.size(); ++i) { // size_t is  a biiiiig int
        ll num = nums[i + 1] - '0';
        if (ops[i] == '+') {
            values.push_back(num);
        } else if (ops[i] == '*') {
            values.back() *= num; // .back() is literally just values[values.length()]
        }
    }

    ll result = 0;
    for (ll v : values) {
        result += v;
    }

    return result % 1000000007;
}

int main() {
    int n, m;
    cin >> n >> m;
    cin.ignore(); // pain-peko

    string firstLine;
    getline(cin, firstLine);

    vector<char> nums;
    vector<char> ops;

    for (size_t i = 0; i < firstLine.length(); ++i) {
        if (i % 2 == 0) {
            nums.push_back(firstLine[i]);
        } else {
            ops.push_back(firstLine[i]);
        }
    }

    cout << eval(nums, ops) << endl;

    for (int i = 0; i < m; ++i) {
        string inn;
        cin >> inn;

        if (inn == "s") {
            int a, b;
            cin >> a >> b;
            swap(nums[a - 1], nums[b - 1]);
        } else if (inn == "f") {
            int a;
            cin >> a;
            if (ops[a - 1] == '+') {
                ops[a - 1] = '*';
            } else if (ops[a - 1] == '*') {
                ops[a - 1] = '+';
            }
        } else {
            for (char& c : ops) { // using pointers instead of a new variable in enhanced for to alter vector directly :)
                if (c == '+') c = '*';
                else if (c == '*') c = '+';
            }
        }

        cout << eval(nums, ops) << endl;
    }

    return 0;
}
