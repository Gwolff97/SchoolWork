#ifndef SCENE_H
#define SCENE_H
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
#include "Material.h"
#include "Light.h"
#include "Sphere.h"
#include "HitRecord.h"

class Scene {

public:
	Scene();
	~Scene();
	int getLightCnt();
	int getSurfaceCnt();
	int getMaterialCnt();
	float* getImageBuffer();
	int getBufferWidth();
	int getBufferHeight();
	std::string toString();
	bool loadNFF(std::string filename, int windowWidth, int windowHeight);
	void cleanup();
	void setPixelinImageBuffer(int x, int y, glm::vec3 color);
	void clearImageBuffer(glm::vec3 color);
	bool intersectRayWithScene(glm::vec3 rayStart, glm::vec3 dayDir, double minDist, HitRecord &bestRecord);
	void raytrace();
private:
	std::vector<Light> All_Lights;
	std::vector<Material*> All_Material;
	float* image_buffer;
	glm::vec3 background_color;
	std::vector<Sphere*> All_Spheres;
	
	
};
#endif // !SCENE_H