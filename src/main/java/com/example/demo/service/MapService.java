package com.example.demo.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class MapService {

	// 맵 생성
	int[][] map;
	int mapHeight; // 맵 높이
	int mapWidth; // 맵 넓이

	// 캐릭터
	int charac = 1; // 캐릭터
	int characXCode; // 몬스터 x축 좌표
	int characYCode; // 몬스터 y축 좌표
	int characHeight = 5; // 캐릭터 높이
	int characWidth = 5; // 캐릭터 넓이

	int road = 0; // 빈공간
	int wall = 9; // 벽

	int mob2 = 2; // 몬스터
	int mob2XCode; // 몬스터 x축 좌표
	int mob2YCode; // 몬스터 y축 좌표
	int mob2Height = 5; // 몬스터 높이
	int mob2Width = 5; // 몬스터 넓이

	int mob3 = 3; // 몬스터
	int mob3XCode; // 몬스터 x축 좌표
	int mob3YCode; // 몬스터 y축 좌표
	int mob3Height = 5; // 몬스터 높이
	int mob3Width = 5; // 몬스터 넓이

	int mob4 = 4; // 몬스터
	int mob4XCode; // 몬스터 x축 좌표
	int mob4YCode; // 몬스터 y축 좌표
	int mob4Height = 5; // 몬스터 높이
	int mob4Width = 5; // 몬스터 넓이

	int mob5 = 5; // 몬스터
	int mob5XCode; // 몬스터 x축 좌표
	int mob5YCode; // 몬스터 y축 좌표
	int mob5Height = 5; // 몬스터 높이
	int mob5Width = 5; // 몬스터 넓이

	int mob6 = 6; // 보스 몬스터
	int mob6XCode; // 몬스터 x축 좌표
	int mob6YCode; // 몬스터 y축 좌표
	int mob6Height = 10; // 보스 몬스터 높이
	int mob6Width = 10; // 보스 몬스터 넓이

	public Map<String, Integer> mapCreation(int mapHeight, int mapWidth, int characXCode, int characYCode, int floor,
			int room) {
		this.characXCode = characXCode;
		this.characYCode = characYCode;
		this.mapHeight = mapHeight;
		this.mapWidth = mapWidth;

		map = new int[mapHeight][mapWidth];

		// 맵 주위를 벽으로 변경
		for (int X = 0; X < mapHeight; X++) {
			for (int Y = 0; Y < mapWidth; Y++) {
				if (X == 0 || X == mapHeight - 1 || Y == 0 || Y == mapWidth - 1)
					map[X][Y] = wall;
			}
		}

		// 캐릭터 위치 부여
		for (int x = characXCode; x < characXCode + characHeight; x++) {
			for (int y = characYCode; y < characYCode + characWidth; y++) {
				map[x][y] = charac;
			}
		}

		// 몬스터 위치 부여
		if (room > 0 && room < 5) {
			int mob2XCode = (int) (Math.random() * 36 + 1); // 좌표 랜덤 지정
			int mob2YCode = (int) (Math.random() * ((36 - 10) + 1)) + 10; // 좌표 랜덤 지정
			this.mob2XCode = mob2XCode;
			this.mob2YCode = mob2YCode;

			for (int x = mob2XCode; x < mob2XCode + mob2Height; x++) {
				for (int y = mob2YCode; y < mob2YCode + mob2Width; y++) {
					map[x][y] = mob2;
				}
			}
		}
		if (room > 1 && room < 5) {
			int mob3XCode = (int) (Math.random() * 36 + 1); // 좌표 랜덤 지정
			int mob3YCode = (int) (Math.random() * ((36 - 10) + 1)) + 10; // 좌표 랜덤 지정
			this.mob3XCode = mob3XCode;
			this.mob3YCode = mob3YCode;

			for (int x = mob3XCode; x < mob3XCode + mob3Height; x++) {
				for (int y = mob3YCode; y < mob3YCode + mob3Width; y++) {
					map[x][y] = mob3;
				}
			}
		}
		if (room > 2 && room < 5) {
			int mob4XCode = (int) (Math.random() * 36 + 1); // 좌표 랜덤 지정
			int mob4YCode = (int) (Math.random() * ((36 - 10) + 1)) + 10; // 좌표 랜덤 지정
			this.mob4XCode = mob4XCode;
			this.mob4YCode = mob4YCode;

			for (int x = mob4XCode; x < mob4XCode + mob4Height; x++) {
				for (int y = mob4YCode; y < mob4YCode + mob4Width; y++) {
					map[x][y] = mob4;
				}
			}
		}
		if (room > 3 && room < 5) {
			int mob5XCode = (int) (Math.random() * 36 + 1); // 좌표 랜덤 지정
			int mob5YCode = (int) (Math.random() * ((36 - 10) + 1)) + 10; // 좌표 랜덤 지정
			this.mob5XCode = mob5XCode;
			this.mob5YCode = mob5YCode;

			for (int x = mob5XCode; x < mob5XCode + mob5Height; x++) {
				for (int y = mob5YCode; y < mob5YCode + mob5Width; y++) {
					map[x][y] = mob5;
				}
			}
		}
		if (floor > 1 && room == 0) {
			int mob6XCode = (int) (Math.random() * 31 + 1); // 좌표 랜덤 지정
			int mob6YCode = (int) (Math.random() * ((31 - 10) + 1)) + 10; // 좌표 랜덤 지정
			this.mob6XCode = mob6XCode;
			this.mob6YCode = mob6YCode;

			for (int x = mob6XCode; x < mob6XCode + mob6Height; x++) {
				for (int y = mob6YCode; y < mob6YCode + mob6Width; y++) {
					map[x][y] = mob6;
				}
			}
		}

		// 맵 상황 확인
		for (int X = 0; X < mapHeight; X++) {
			for (int Y = 0; Y < mapWidth; Y++) {
				System.err.print(map[X][Y]);
			}
			System.err.println();
		}

		Map<String, Integer> codes = new HashMap<String, Integer>();

		codes.put("mob2XCode", mob2XCode);
		codes.put("mob2YCode", mob2YCode);
		codes.put("mob3XCode", mob3XCode);
		codes.put("mob3YCode", mob3YCode);
		codes.put("mob4XCode", mob4XCode);
		codes.put("mob4YCode", mob4YCode);
		codes.put("mob5XCode", mob5XCode);
		codes.put("mob5YCode", mob5YCode);
		codes.put("mob6XCode", mob6XCode);
		codes.put("mob6YCode", mob6YCode);

		return codes;
	}

	public String keyUp(int something) {
		if (map[characXCode - 1][characYCode] <= 1 && map[characXCode - 1][characYCode + 1] <= 1
				&& map[characXCode - 1][characYCode + 2] <= 1 && map[characXCode - 1][characYCode + 3] <= 1
				&& map[characXCode - 1][characYCode + 4] <= 1) {

			for (int x = characXCode; x < characXCode + characHeight; x++) {
				for (int y = characYCode; y < characYCode + characWidth; y++) {
					map[x][y] = road;
				}
			}

			characXCode--;

			for (int x = characXCode; x < characXCode + characHeight; x++) {
				for (int y = characYCode; y < characYCode + characWidth; y++) {
					map[x][y] = something;
				}
			}

			/*
			 * if (something == charac) { characXCode--; } else if (something == mob2) {
			 * mob2XCode--; }
			 */
		} else {
			return "Lost";
		}
		// 맵 상황 확인
		for (int X = 0; X < mapHeight; X++) {
			for (int Y = 0; Y < mapWidth; Y++) {
				System.err.print(map[X][Y]);
			}
			System.err.println();
		}
		return "success";
	}

	public String keyDown(int something) {
		if (map[characXCode + 5][characYCode] <= 1 && map[characXCode + 5][characYCode + 1] <= 1
				&& map[characXCode + 5][characYCode + 2] <= 1 && map[characXCode + 5][characYCode + 3] <= 1
				&& map[characXCode + 5][characYCode + 4] <= 1) {

			for (int x = characXCode; x < characXCode + characHeight; x++) {
				for (int y = characYCode; y < characYCode + characWidth; y++) {
					map[x][y] = road;
				}
			}

			characXCode++;

			for (int x = characXCode; x < characXCode + characHeight; x++) {
				for (int y = characYCode; y < characYCode + characWidth; y++) {
					map[x][y] = something;
				}
			}

			/*
			 * if (something == charac) { characXCode--; } else if (something == mob2) {
			 * mob2XCode--; }
			 */
		} else {
			return "Lost";
		}
		// 맵 상황 확인
		for (int X = 0; X < mapHeight; X++) {
			for (int Y = 0; Y < mapWidth; Y++) {
				System.err.print(map[X][Y]);
			}
			System.err.println();
		}
		return "success";
	}

	public String keyLeft(int something) {
		if (map[characXCode][characYCode - 1] <= 1 && map[characXCode + 1][characYCode - 1] <= 1
				&& map[characXCode + 2][characYCode - 1] <= 1 && map[characXCode + 3][characYCode - 1] <= 1
				&& map[characXCode + 4][characYCode - 1] <= 1) {

			for (int x = characXCode; x < characXCode + characHeight; x++) {
				for (int y = characYCode; y < characYCode + characWidth; y++) {
					map[x][y] = road;
				}
			}

			characYCode--;

			for (int x = characXCode; x < characXCode + characHeight; x++) {
				for (int y = characYCode; y < characYCode + characWidth; y++) {
					map[x][y] = something;
				}
			}

			/*
			 * if (something == charac) { characXCode--; } else if (something == mob2) {
			 * mob2XCode--; }
			 */
		} else {
			return "Lost";
		}
		// 맵 상황 확인
		for (int X = 0; X < mapHeight; X++) {
			for (int Y = 0; Y < mapWidth; Y++) {
				System.err.print(map[X][Y]);
			}
			System.err.println();
		}
		return "success";
	}

	public String keyRight(int something) {
		if (map[characXCode][characYCode + 5] <= 1 && map[characXCode + 1][characYCode + 5] <= 1
				&& map[characXCode + 2][characYCode + 5] <= 1 && map[characXCode + 3][characYCode + 5] <= 1
				&& map[characXCode + 4][characYCode + 5] <= 1) {

			for (int x = characXCode; x < characXCode + characHeight; x++) {
				for (int y = characYCode; y < characYCode + characWidth; y++) {
					map[x][y] = road;
				}
			}

			characYCode++;

			for (int x = characXCode; x < characXCode + characHeight; x++) {
				for (int y = characYCode; y < characYCode + characWidth; y++) {
					map[x][y] = something;
				}
			}

			/*
			 * if (something == charac) { characXCode--; } else if (something == mob2) {
			 * mob2XCode--; }
			 */
		} else {
			return "Lost";
		}
		// 맵 상황 확인
		for (int X = 0; X < mapHeight; X++) {
			for (int Y = 0; Y < mapWidth; Y++) {
				System.err.print(map[X][Y]);
			}
			System.err.println();
		}
		return "success";
	}

}