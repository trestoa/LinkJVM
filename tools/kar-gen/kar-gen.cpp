#include "kar/kar.hpp"
#include <QString>

int main(int argc, char* argv[]){
	kiss::KarPtr archive = kiss::Kar::create();
	archive->save(argv[1]);
    return 0;
}

