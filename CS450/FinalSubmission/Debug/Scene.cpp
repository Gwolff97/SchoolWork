#include "Scene.h"
#include <cstring>
#include <iostream>
#include <fstream>
#include <algorithm>
#include <vector>
#include <string>
#include <cmath>
#include <thread>
#include <chrono>
#include <sstream>
#include "glm/glm.hpp"					// NOTE: Need to compile, hence the quotes
#include "glm/gtx/string_cast.hpp"

using namespace std;

char first_word;
char red, blue, green;

Scene::Scene() {
	image_buffer = NULL;
	width_buffer = 0;
	height_buffer = 0;
	background_color = (glm::vec3) (0, 0, 0);
};

Scene::~Scene() { cleanup(); };


int Scene::getLightCnt() {
	return All_Lights.size();
	
};

int Scene::getSurfaceCnt() {
	return All_Spheres.size();
};

int Scene::getMaterialCnt() {
	return All_Material.size();
};

float* Scene::getImageBuffer() {
	return image_buffer;
};

int Scene::getBufferWidth() {
	return width_buffer;
};

int Scene::getBufferHeight() {
	return height_buffer;
};

string Scene::toString() {

		string combined;

		combined = (red, green, blue + "/n");

		return combined;
};

bool Scene::loadNFF(string filename, int windowWidth, int windowHeight) {
	ifstream inFile;
	std::string line;

	inFile.open(filename);

	if (!inFile) {
		return false;
	}

	else {
		cleanup();
		int currentMax_index = -1;
		while (!inFile.eof()) {
			getline(inFile,line);
			stringstream ss(line);
			ss >> first_word;

			if (first_word == 'l') {
				Light *new_light = new Light();
				All_Lights.push_back(new_light);
			}
			if (first_word == 's') {
				Sphere *new_sphere = new Sphere();
				new_sphere -> setMaterialIndex(currentMax_index);
				All_Spheres.push_back(new_sphere);
			}
			if (first_word == 'f') {
				Material *new_material = new Material();
				All_Material.push_back(new_material);
				currentMax_index++;
			}
			if (first_word == 'b') {
				ss >> red >> green >> blue;
			}

		}
		inFile.close();
		width_buffer = windowWidth;
		height_buffer = windowHeight;
		return true;
	}



};

void Scene::cleanup() {
	All_Lights.clear();
	All_Spheres.clear();
	All_Material.clear();
};