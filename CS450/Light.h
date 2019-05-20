#ifndef LIGHT_H
#define LIGHT_H
#include <iostream>
#include <fstream>
#include <algorithm>
#include <vector>
#include <string>
#include <cmath>
#include <thread>
#include <chrono>
#include <cstring>
#include "glm/glm.hpp"					// NOTE: Need to compile, hence the quotes
#include "glm/gtx/string_cast.hpp"


class Light {
public:
	Light();
	Light(glm::vec3 pos);
	Light(glm::vec3 pos, glm::vec3 color);
	glm::vec3 getPos();
	glm::vec3 getColor();
	std::string toString();
	void read(std::string data);
	


private:
	glm::vec3 position;
	glm::vec3 color_priv;
	char ldummy;
	char lposX, lposY, lposZ, colorR, colorG, colorB;
	
	
};

#endif // !LIGHT_H


