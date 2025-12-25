class Solution {
public:
    vector<string> restoreIpAddresses(string s) {
    vector<string> Ips;
    vector<string> temp;
    getIpAddresses(temp , Ips , s , 0);
    return Ips;
    }
    void getIpAddresses(vector<string> &temp , vector<string> &Ips , string &s , int index){
        if(index == s.length() && temp.size() == 4){
            string validIp = temp[0] + '.' + temp[1] + '.' + temp[2] + '.' + temp[3];
            Ips.push_back(validIp);
            return;
        }
        string tempstr =  "";
        for(int i = index ; i < s.length() && temp.size() < 4 ; i++ ){
            if(s[i] - '0' > 9)
            continue;
            tempstr += s[i];
            int tempInt = stoi(tempstr);
            if(0 <= tempInt && tempInt <= 255){
                temp.push_back(tempstr);
                getIpAddresses(temp , Ips , s , i+1);
                temp.pop_back();
            }
            if(tempInt <= 0 || tempInt > 255)
            break;
        }
    }
};