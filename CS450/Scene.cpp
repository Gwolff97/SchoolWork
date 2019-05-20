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
#include "Material.h"
#include "HitRecord.h"

using namespace std;

char first_word;
char red, blue, green;
int width_buffer, height_buffer;


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
				Light new_light = Light();
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

void Scene::clearImageBuffer(glm::vec3 color) {
	int i, j;
	for (i = 0; i < height_buffer; i++) {
		for (j = 0; j < width_buffer; j++) {
			image_buffer[(i*width_buffer + j) * 3] = color.r;
			image_buffer[(i*width_buffer + j) * 3 + 1] = color.g;
			image_buffer[(i*width_buffer + j) * 3 + 2] = color.b;
		}
	}
}

void Scene::setPixelinImageBuffer(int x, int y, glm::vec3 color) {
	int index = (y*width_buffer + x) * 3;
	image_buffer[index] = color.r;
	image_buffer[index + 1] = color.g;
	image_buffer[index + 2] = color.b;
}

bool Scene::intersectRayWithScene(glm::vec3 rayStart, glm::vec3 rayDir, double minDist, HitRecord &bestRecord) {
	bool anyHit = false;
	double miniDist = minDist;


	for (int i = 0; i < All_Spheres.size(); i++) {
		Sphere *temp = All_Spheres[i];
		bool inter_true = temp->Sphere::getIntersection(rayStart, rayDir, bestRecord);

		if (inter_true == true) {
			if (bestRecord.getT() > miniDist) {
				if (anyHit == false) {
				bestRecord.setT(bestRecord.getT());
				anyHit = true;
				}
			}
		}
	}

	return anyHit;
};


void Scene::raytrace() {
	clearImageBuffer(glm::vec3(0, 0, 0));
	int nx = width_buffer;
	int ny = height_buffer;
	double nearDist = 0;
	int aspectratio = nx / ny;
	double imagePlaneHeight = 2.0;
	double imagePlaneWidth = imagePlaneHeight * aspectratio;
	double left = -imagePlaneWidth / 2.0f;
	double right = imagePlaneWidth / 2.0f;
	double bottom = -imagePlaneHeight / 2.0f;
	double top = imagePlaneHeight / 2;
	glm::vec3 U = glm::vec3(1, 0, 0);
	glm::vec3 V = glm::vec3(0, 1, 0);
	glm::vec3 W = glm::vec3(0, 0, 1);
	glm::vec3 E = glm::vec3(0, 0, 1.5);
	float d = 1.0;
	
	for (int i = 0; i <= nx; i++) {
		for (int j = 0; j <= ny; j++) {
			float u = left + (right - left) * (i + 0.5f) / nx;
			float v = bottom + (top - bottom) * (j + .5f) / ny;
			glm::vec3 rayDir = u * U + v * V + d * W;
			glm::vec3 rayStart = E;

				HitRecord *bestRecord = new HitRecord();
				if (intersectRayWithScene(rayStart, rayDir, nearDist, *bestRecord) == true) {
					
					Material *temp2 = new Material;
						temp2 = All_Material[i];
						glm::vec3 colored = temp2->getColor();
					setPixelinImageBuffer(i, j, colored);
				}

			}
	}

};