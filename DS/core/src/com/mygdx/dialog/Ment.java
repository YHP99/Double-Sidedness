package com.mygdx.dialog;

import java.util.ArrayList;

public class Ment {
	public ArrayList<String> intro() // BIT 제외
	{
		ArrayList<String> ment = new ArrayList<String>();

		ment.add("[System]\n" + "ENTER 키를 눌러 창을 넘깁니다.");

		ment.add("Intro\n" + "2250년 인류는 연구 끝에 지식을 습득 할 수 있는 알약을 개발하였다.\n\n" + "인류가 발전함에 따라 사회는 더욱 양극화 되었고\n"
				+ "부유한 상위계층(RIPA거주자)만이 그 혜택을 누릴 수 있었다.");

		ment.add("따라서 가난한 하위계층(GPA거주자)은 문명으로 부터 멀어지게 되고 \n"
				+ "점점 격차는 심해지며 월등한 존재로 군림한 RIPA거주자들의 횡포는 심해져 간다.\n" 
				+ "견디다 못한 GPA거주자들은 살기위한 투쟁을 시작한다.");
		
		ment.add(".....왜?");

		ment.add("RIPA거주자들이 가질 수 없는 한가지 그 한가지를 GPA거주자들은 가지고 있다.");

		ment.add("그것은.....");

		return ment;
	}

	// 1 스테이지 시작할 때 BIT 제외
	public ArrayList<String> ment1() {
		ArrayList<String> ment = new ArrayList<String>();

		ment.add("[벽뒤 RIPA 거주자]\n" + "이봐! 거기 멈춰 니가 마지막이다 순순히 투항해라!");

		ment.add("[???]\n" + "우리에게 대체 왜 이러는거지?\n" + "우린 우리의 생존을 위해 너희와 싸울 뿐 다른 목적은 없다!");

		ment.add("[벽뒤 RIPA 거주자]\n" + "우리 연구에 순순히 동참하시지 하등한 너희가 가질 수 있는 건 없다\n" + "어서 너희 거주민들 처럼 순순히 투항해라");

		ment.add("[???]\n" + "(필요한 것은 모두 갖추었다. 이제 그 ???만 찾으면돼)\n" + "지식이 넘쳐나고 부유하단 이유로 우리를 탄압하는 너희가 옳다고 생각하나?\n"
				+ "우리는 가난하고 지식이 부족하단 이유로 너희로부터 억압 받았다 이젠 그럴 수 없어!");

		ment.add("[벽뒤 RIPA 거주자 ]\n" + "거기서!");

		ment.add("[System]\n" + "기본 조작은 방향키로 이동하며 Space Bar는 점프입니다.\n" + "이벤트 발생은 해당 NPC 및 오브젝트에 접근할 시 자동으로 발생합니다.");

		ment.add("[???]\n" + "이곳을 탈출해야해 어서 그 ???를 구해서 이 악순환을 끝내야해");

		ment.add("[System]\n" + "사망시 스타팅 포인트로 다시 되돌아 오게 됩니다. 함정을 피해 ???를 찾고 이야기를 완성하세요");

		return ment;
	}

	public ArrayList<String> ment2() {
		ArrayList<String> ment = new ArrayList<String>();
		ment.add("[Zico]\n" + "어서... ???를 찾아줘 우리의 동료들이 계속해서 사라지고 있어 \n" + "근처에 선대 ???께서 숨어계서 그 분을 찾아가");
		return ment;
	}

	public ArrayList<String> ment3() {
		ArrayList<String> ment = new ArrayList<String>();

		ment.add("[선대 ???]\n" + "...\n" + "숨어있는 날 찾아온 이유는 그것뿐이겠지 \n" + "후대여 무엇을 바라는가 ");

		ment.add("[???]\n" + "그 ???을 사용해 저 악행을 저지르는 RIPA 사람들을 없애고 싶습니다");

		ment.add("[선대 ???]\n" + "그렇게 되면 니가 저들과 다른 것이 있는가?");

		ment.add("[???]\n" + "다릅니다 분명히 다릅니다 저들은 기득권이라는 이유로 우리를 억압했습니다 \n"
				+ "그들에게 없는 힘이 우리에겐 분명히 있고 그 힘을 우리가 가진 이유가 있지 않겠습니까 \n" + "바로 지금을 위한 겁니다.");

		ment.add("[EastGod]\n" + "...\n" + "니가 그렇게 생각한다면 그러한 것이겠지 \n" + "이곳의 끝으로 가라 니가 찾는 ???는 그곳에 있다");

		return ment;
	}

	public ArrayList<String> ment4() {
		ArrayList<String> ment = new ArrayList<String>();

		ment.add("[웅토로]\n" + "???님께서 결국 그 ???를 찾으러 가는군요\n" + "전설에 따르면 그 ???는 엄청난 힘을 가지고 있죠\n"
				+ "우리가 믿을건 ???님 당신 밖에 없습니다. 꼭 찾아주세요");

		return ment;
	}

	// NPC 아님, 2스테이지로 넘어갈 때
	public ArrayList<String> ment5() {
		ArrayList<String> ment = new ArrayList<String>();
		ment.add("[???]\n" + "전설에 이 \"악보\"는 듣는 순간 악한 사람들을 전부 죽인다고 했어  \n"
				+ "부유하고 캡슐로 지식을 얻은 그들을 가난해 캡슐을 얻지 못한 우리가 없앨 수 있는 방법은 이것 밖에 없어");

		ment.add("[GM]\n" + "이 \"악보\"가 우리의 미래를 바꿔줄거야...\n");

		ment.add("[System]\n" + "오른쪽에 있는 악보를 통해 다음 스테이지로 이동할 수 있습니다.");

		return ment;
	}

	/////////////////////////////////////////////////////////////////////////////////////////////

	// 2스테이지 시작할 때 BIT 제외
	public ArrayList<String> ment6() {
		ArrayList<String> ment = new ArrayList<String>();
		ment.add("[GM]\n" + "악보는 찾았지만 일부분일 뿐이야\n" + "어서 나머지 악보를 찾아야해");

		ment.add("[GM]\n" + "난 틀리지 않았어 절대로\n" + "음악의 재능은 우리가 가진 유일한 것이야 이것마저 뺏길순 없어");
		return ment;
	}

	public ArrayList<String> ment7() {
		ArrayList<String> ment = new ArrayList<String>();
		ment.add("[Slav]\n" + "우리는 항상 부족하게 살아왔고 저들보다 뛰어난것도 없습니다. \n"
				+ "다만 그들은 우리가 재력을 가졌을 뿐이고 그들은 오만함에 눈이멀어 우리를 탄압하고 억압하고 있습니다. \n" + "우리 역시 그들이 없는 재능을 가지고 있습니다. \n"
				+ "우리 역시 그들과 같아지지 않는다는 장담을 할 순 없겠죠 \n" + "당신은 눈이 멀지 않기를...");

		return ment;
	}

	public ArrayList<String> ment8() {
		ArrayList<String> ment = new ArrayList<String>();
		ment.add("[Donka]\n" + "GM님 당신은 무엇을 위해 앞으로 나아가고 계신가요? \n" + "당신의 눈빛엔 증오와 오만밖에 보이지 않습니다. \n"
				+ "음악의 재능을 가지신 당신이 아무것도 없는 우리를 대변한다 생각하지 마십시오\n" + "당신의 재능은 특별한것이 아닙니다.");

		ment.add("[GM]\n" + "당신이 뭘안다고 그렇게 말씀하시는거죠?\n" + "RIPA거주자들은 오만함에 눈이 멀었어\n"
				+ "우리를 죽이고 납치해서 실험을 하고 있습니다 이게 옳은 행동일까요? \n" + "현실을 바라보세요");

		return ment;
	}

	/////////////////////////////////////////////////////////////////////////////////////////////

	// 3스테이지 시작할 때 BIT 제외
	public ArrayList<String> ment9() {
		ArrayList<String> ment = new ArrayList<String>();
		ment.add("[GM]\n" + "악보의 일부를 찾았어!\n" + "이 곡으로 RIPA를 모조리 죽이고 우리는 생존할거야\n" + "남은 악보를 찾으러 가야겠어");

		return ment;
	}

	public ArrayList<String> ment10() {
		ArrayList<String> ment = new ArrayList<String>();

		ment.add("[Bpie]\n" + "잠시만요! GM님 멈춰주세요! \n" + "당신은 지금 RIPA거주자와 다른것이 없습니다.\n" + "거기서 그만두세요!");

		ment.add("[GM]\n" + "조용히 하세요! 지금 멈추면 우리는 모두 죽게될거에요 넋놓고 그렇게 바라만 볼껀가요 ?\n" + "어서 비키세요!");

		return ment;
	}

	public ArrayList<String> ment11() {
		ArrayList<String> ment = new ArrayList<String>();

		ment.add("[Ari]\r\n" + "당신은 점점 미쳐가고 있습니다. \n" + "이 광기를 멈추셔야합니다.\n" + "당신의 모습을 보세요 지금 우리의 영웅이던 GM의 모습은 없어지고 \n"
				+ "광기어린 살인마의 모습밖에 남지 않았습니다.");

		ment.add("[GM]\n" + "조용히해! \n" + "나를 제외한 GM모두가 잡혀가고 민간인들 까지도 모두 죽어가고 있어 \n"
				+ "지금 멈추면 누가 그들의 억울함을 풀어주고 앞으로 죽을 사람들을 구하지 ?\n" + "냉정하게 생각해 우리가 그들보다 나은것은 아무것도 없어!");

		ment.add("[Ari]\n" + "... 알겠습니다 앞으로 가십시오 ");

		return ment;
	}

	/////////////////////////////////////////////////////////////////////////////////////////////

	// 4스테이지 시작할 때 BIT 제외
	public ArrayList<String> ment12() {
		ArrayList<String> ment = new ArrayList<String>();

		ment.add("[GM]\n" + "좋아 모든 악보를 모았어!\n" + 
		"연주를 시작해야겠어 우리는 RIPA로부터 해방되는거야 ");

		return ment;
	}

	// 4스테이지 RIPA 지휘관과 대화
	public ArrayList<String> ment13() {
		ArrayList<String> ment = new ArrayList<String>();

		ment.add("[RIPA지휘관]\n" + "이봐 거기! 뭐하는거지 ?\n" + "너는... GM이군 다 잡은줄 알았는데 용케 살아남았군\n" + "제군들 저자를....윽 이게 무슨");

		ment.add("[GM]\n" + "너희가 우리보다 우월하고 월등한 존재라 생각했겠지만 너희는 결국 음악의 재능은 손에 넣지 못했다! \n"
				+ "지금 들리는 이곡은 악한이를 모두 죽이는 전설의 악보 \n" + "너희를 모두 죽이고 우리 GPA거주자들은 다시 일상으로 돌아 갈 수 있다!");

		ment.add("[RIPA지휘관]\n" + "어...어리석군\n" + "니가 그러면 우리와 달리지는게  뭐지? 하여튼 멍청한것 윽\n"
				+ "니가 이겼다고 생각하지마라 우리는 이정도로 쓰러질 만큼 약하지 않다\n" + "니가 GPA 거주민중에 좀 뛰어나다고 우리를 막을수 없....");

		ment.add("[GM]\n" + "이제 우리의 세상이야 우리도 자유롭게 캡슐로 지식을 습득하고\n" + "너희의 지배를 받지 않는 세상을 만들거야 역시 내가 옳았어 옳았다고!! \n" + "\n"
				+ "....?\n" + "이...이게 무슨일이야 \n" + "안돼 안된다고!! 이게 무슨일...");

		return ment;
	}
	
	// 4스테이지 클리어 부분
	public ArrayList<String> ment13_clear(String code) {
		ArrayList<String> ment = new ArrayList<String>();
		
		ment.add("이게 끝이라고 생각하나요?\n\n"+"Code : "+code);

		return ment;
	}

	// 5스테이지(보너스) 시작할 때 BIT 제외
	public ArrayList<String> ment14() {
		ArrayList<String> ment = new ArrayList<String>();

		ment.add("[GM]\n" + "...?\n" + "어째서 다시 살아나고 있는거지?\n" + 
		"왜 어째서 이곡은 악한이를 죽이는 전설의 곡이야\n" + "왜 어째서\n" + "어째서냐고");

		return ment;
	}

	// 5스테이지(보너스) EastGod과 대화
	public ArrayList<String> ment15() {
		ArrayList<String> ment = new ArrayList<String>();

		ment.add("[EastGod]\n" + "내가 잘못 생각 했구나 GM이여");

		ment.add("[GM]\n" + "그게 무슨 말씀이십니까?");

		ment.add("[EastGod]\n" + "그 곡은 악한이를 죽이는 곡이 아니야\n" + "그 악한 마음을 치유하는 곡이지...\n" + "니가 잘못된 선택을 하지않고\n"
				+ "선한 마음으로 쓰길 바랬다.");

		ment.add("[EastGod]\n" + "하지만 악보를 찾는 과정에서 너는 결국\n" + "증오와 복수심에 사로 잡혀 버렸구나\n\n" + "GM 이여 그 곡을 연주하여\n"
				+ "마음이 악해진 저들과 자네를 치유하게\n" + "우리의 근본은 복수와 증오가 아니야");

		ment.add("[GM]\n" + "안됩니다!\n" + "지금까지 죽어간 GM들과 GPA거주민들의 억울함은 누가 어떻게 풀어줍니까?\n" + "생각해 보십시오!\n"
				+ "이 악순환을 어떻게 끊어야 합니까?");

		ment.add("[EastGod]\n" + "그 고리를 끊기위해 우리의 선조들은 악보를 남겼겠지\n" + "그리고 그들은 평화를 추구했다.\n"
				+ "우리에게 주어진 음악이란 힘은 사람을 해하는것이 아니라 사람을 치유하기위해 존재하지\n" + "모든일엔 다 이유가 있고 뜻이 있다. \n"
				+ "젊은 GM이여 그만 포기하고 모든이를 치유해라");

		ment.add("[GM]\n" + "닥쳐! 이건 아니야 이건... 이건!!!");

		ment.add("[GM]\n" + "아아악! 이게 아니야 내가 바라던건 이게 아니라고!");

		ment.add("[EastGod]\n" + "포기하게 젊은 GM이여\n" + "이 악순환을 끊을 수 있는건 자네 밖에 없다네");

		ment.add("[GM]\n" + "그만! 그만해! 이악보를... 이 악보를! 이건 전설의 악보가 아닐거야 분명 다른 악보가 존재한다고!\n"
				+ "내가 추해진건지 당신이 틀린건지 잘생각해 ! 이건 ! 이건!!");

		ment.add("[EastGod]\n" + "... 추해질대로 추해졌구나 GM\n" + "그 악보를 이리 주게 자네가 할 수 없다면 내가 하겠네");

		ment.add("[GM]\n" + "..........\n" + "여기 악보를 가져가 난 더이상  아무것도 할 수 없어");

		ment.add("[EastGod]\n" + "이곳에서 잠시 쉬게\n" + "내가 자네를 고쳐줄테니...");

		return ment;
	}

	// Credit BIT 제외
	public ArrayList<String> credit() {
		ArrayList<String> ment = new ArrayList<String>();

		ment.add("Credit\n" + "3조 Double Sidedness");

		ment.add("Original Story - \"Ebony\"");

		ment.add("Sound Track\n" + "Stage 1 - Beginning\n" + "Stage 2 - Weed\n" + "Stage 3 - Ebony\n"
				+ "Stage 4 - Double Sidedness\n" + "Hidden Stage - Anywhere I was out");

		ment.add("자료조사 - 전원\n" + "기능구현 - 전원\n" + "그래픽 - 전원\n" + "스토리 - 박영훈\n" + "OST - 나경태\n" + "서버 - 김준성\n"
				+ "DB - 황현웅");

		ment.add("Special Thank to\n" + "음향 조언 - Neken kim\n" + "기술조언 - ㅎㅇㅈㄴㄷ\n" + "그래픽 조언 - Studio K\n"
				+ "테스트 - 경, KoreaTG, 박준수\n" +
				"추가 테스트 - 그저 빛, ㅎㅇㅈㄴㄷ");

		ment.add("Thank you For Playing");

		return ment;
	}
}
