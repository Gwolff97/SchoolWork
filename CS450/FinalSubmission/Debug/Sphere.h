#ifndef SPHERE_H
#define SPHERE_H
#include <cstring>
#include <iostream>
#include <fstream>
#include <algorithm>
#include <vector>
#include <string>
#include <cmath>
#include <thread>
#include <chrono>
#include "glm/glm.hpp"					// NOTE: Need to compile, hence the quotes
#include "glm/gtx/string_cast.hpp"


class Sphere {
public:
	Sphere();
	Sphere(glm::vec3 center, double radius);
	glm::vec3 getCenter();
	double getRadius();
	std::string toString();
	void read(std::string data);
	void setMaterialIndex(int matIndex);
	int getMaterialIndex();


private:
	glm::vec3 position;
	double radiusP;
	int Material_index;

};

#endif // !SPHERE_H
