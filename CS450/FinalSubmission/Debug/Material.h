#ifndef MATERIAL_H
#define MATERIAL_H
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

class Material {
public:
	Material();
	Material(glm::vec3 diffuse_colorr, float Kdm, float Ksm, float shinerm, float Tm, float index_of_refraction);
	glm::vec3 getColor();
	float getKd();
	float getKs();
	float getShine();
	float getTransmittance();
	float getIndexRefraction();
	void read(std::string data);
	std::string toString();

private:
	glm::vec3 diffuse_color;
	float Kd,Ks,shininess, transmittance, refraction_index;
};
#endif // !MATERIAL_H