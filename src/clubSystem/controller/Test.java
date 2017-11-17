package clubSystem.controller;

import java.io.Reader;
import java.util.Scanner;

import javax.sound.midi.SysexMessage;

import clubSystem.model.*;
import clubSystem.view.*;

public class Test {
	 static String USER_COMEIN_TIPS="Hi~ 这里是主界面哒!\n"
				+"所有操作说明如下:\n"
				+"查看社团详情 --输入“gC+社团编号”(eg:gC1,gC2...)\n"
				+"查看活动详情 --输入“gA+活动编号”(eg:gA1,gA2...)\n"
				+"查找社团 --输入“fC+社团名”(eg:fC话剧社)\n"
				+"查找活动（默认查找活动名）--输入“fA+活动名”(eg:fA小提琴演奏)\n"
				+"查找活动（按照时间筛选_输入时间前的活动）--输入“fATb+时间”(eg:ATb2017.01.01)\n"
				+"查找活动（按照时间筛选_输入时间后的活动）--输入“fATa+时间”(eg:ATa2017.01.01)\n"
				+"查找活动（按照社团筛选）--输入“fAC+社团名”(eg:AC话剧社)\n"
				+"退出系统 --输入t\n";
	 static String USER_GOON_TIPS="\n\n查看社团详情 --输入“gC+社团编号”(eg:gC1,gC2...)\n"
				+"查看活动详情 --输入“gA+活动编号”(eg:gA1,gA2...)\n"
				+"查找社团 --输入“fC+社团名”(eg:fC话剧社)\n"
				+"查找活动（默认查找活动名）--输入“fA+活动名”(eg:fA小提琴演奏)\n"
				+"查找活动（按照时间筛选_输入时间前的活动）--输入“fATb+时间”(eg:ATb2017.01.01)\n"
				+"查找活动（按照时间筛选_输入时间后的活动）--输入“fATa+时间”(eg:ATa2017.01.01)\n"
				+"查找活动（按照社团筛选）--输入“fAC+社团名”(eg:AC话剧社)\n"
				+"退出系统 --输入t\n"
				+"如继续操作请输入指令： ";
	 static String MANAGER_COMEIN_TIPS="Welcome~这里就是你的天下啦，行使管理的权利吧!\n"
				+"所有操作说明如下:\n"
				+"查看社团详情 --输入“gC+社团编号”(eg:gC1,gC2...)\n"
				+"查看活动详情 --输入“gA+活动编号”(eg:gA1,gA2...)\n"
				+"查找社团 --输入“fC+社团名”(eg:fC话剧社)\n"
				+"查找活动（默认查找活动名）--输入“fA+活动名”(eg:fA小提琴演奏)\n"
				+"查找活动（按照时间筛选_输入时间前的活动）--输入“fATb+时间”(eg:ATb2017.01.01)\n"
				+"查找活动（按照时间筛选_输入时间后的活动）--输入“fATa+时间”(eg:ATa2017.01.01)\n"
				+"查找活动（按照社团筛选）--输入“fAC+社团名”(eg:AC话剧社)\n"
				+"======================以下是特权操作哦=====================\n"
				//以上用户能进行的操作管理员同样可以
				//以下是管理员特权哦
				+"查看某个社团的所有成员列表 --输入“gCM+社团编号”(eg:gCM1,gcM2...)\n"
				+"对社团进行排序 --输入“rC+排序规则(activityTimes/memberNumbers)”(eg:rCmemberNumbers)\n"
				+"所有活动信息汇总 --输入“allA”\n"
				+"添加活动补充信息 --输入“addA+活动编号,类型名称,人员名称数组”(eg:addA12,参与者,陈刚、李铁)\n"
				+"删除活动补充信息 --输入“delA+活动编号,类型名称”(eg:delA1,参演者)\n"
				+"修改活动补充信息 --输入“updA+活动编号,原来类型,修改后类型,人员名称数组”(eg:addA3,演讲人,主持人,陈刚、李铁)\n"
				+"退出系统 --输入t\n";
	 static String MANAGER_GOON_TIPS="\n所有操作说明如下:\n"
				+"查看社团详情 --输入“gC+社团编号”(eg:gC1,gC2...)\n"
				+"查看活动详情 --输入“gA+活动编号”(eg:gA1,gA2...)\n"
				+"查找社团 --输入“fC+社团名”(eg:fC话剧社)\n"
				+"查找活动（默认查找活动名）--输入“fA+活动名”(eg:fA小提琴演奏)\n"
				+"查找活动（按照时间筛选_输入时间前的活动）--输入“fATb+时间”(eg:ATb2017.01.01)\n"
				+"查找活动（按照时间筛选_输入时间后的活动）--输入“fATa+时间”(eg:ATa2017.01.01)\n"
				+"查找活动（按照社团筛选）--输入“fAC+社团名”(eg:AC话剧社)\n"
				+"======================以下是特权操作哦=====================\n"
				//以上用户能进行的操作管理员同样可以
				//以下是管理员特权哦
				+"查看某个社团的所有成员列表 --输入“gCM+社团编号”(eg:gCM1,gcM2...)\n"
				+"对社团进行排序 --输入“rC+排序规则(activityTimes/memberNumbers)”(eg:rCmemberNumbers)\n"
				+"所有活动信息汇总 --输入“allA”\n"
				+"添加活动补充信息 --输入“addA+活动编号,类型名称,人员名称数组”(eg:addA12,参与者,陈刚、李铁)\n"
				+"删除活动补充信息 --输入“delA+活动编号,类型名称”(eg:delA1,参演者)\n"
				+"修改活动补充信息 --输入“updA+活动编号,原来类型,修改后类型,人员名称数组”(eg:addA3,演讲人,主持人,陈刚、李铁)\n"
				+"退出系统 --输入t\n"
				+"如继续操作请输入指令：";
	
	 public static void main(String[] Sargs) throws Exception {
		    Board aBoard=new Board();
		    Scanner reader=new Scanner(System.in);
			System.out.println("终于等到你啦ヾ(◍°∇°◍)ﾉ\n(用户)输入u激活系统并进入主界面，(管理员)输入m进入管理界面，输入t退出系统——————请输入：");	
			String input=reader.next();
			while ((!input.equals("u"))&&(!input.equals("m"))&&(!input.equals("t"))) {
				System.out.println("输入不符合格式,请重新输入：");
				input=reader.next();
			}
			if(input.equals("t")) {
				System.out.println("再见啦朋友");
			}
			//用户操作
			if(input.equals("u")) {
				System.out.println(USER_COMEIN_TIPS);
				//自动显示所有社团列表和活动列表
				System.out.println(aBoard.displayAllClubsName());
				System.out.println(aBoard.displayAllActivitiesName());
				System.out.println("请输入：");
				input=reader.next();
				while(!input.equals("t")) {
					//查看社团详情 --输入“gC+编号”(eg:gC1,gC2...)
					if(input.substring(0,2).equals("gC")) {
						int inputClubID=Integer.parseInt(input.substring(2));
						System.out.println(aBoard.getDetails(inputClubID, "club"));
					}
					//查看活动详情 --输入“gA+编号”(eg:gA1,gA2...)
					if(input.substring(0,2).equals("gA")) {
						int inputActivityID=Integer.parseInt(input.substring(2));
						System.out.println(aBoard.getDetails(inputActivityID, "activity"));
					}
					//查找社团 --输入“fC+社团名”(eg:fC话剧社)
					if(input.substring(0,2).equals("fC")) {
						String inputClubName=input.substring(2);
						System.out.println(aBoard.searchClubByName(inputClubName).getClubDetails());
					}
					//查找活动
					if(input.substring(0,2).equals("fA")) {
						//查找活动（按照社团筛选）--输入“fAC+社团名”(eg:AC话剧社)
						if(input.substring(0,3).equals("fAC")) {
							String inputClubName=input.substring(3);
							String findResult="";
							for(Activity a:aBoard.chooseActivityByClub(inputClubName)) {
								findResult+=a.getActivityDetails()+"\n\n";
							}
							System.out.println(findResult);
						}
						else {
							if(input.substring(0,3).equals("fAT")) {
							    //查找活动（按照时间筛选_输入时间前的活动）--输入“fATb+时间”(eg:ATb2017.01.01)
								if(input.substring(0,4).equals("fATb")) {
									String inputActivityTime=input.substring(4);
									String findResult="";
									for(Activity a:aBoard.chooseActivityByTime(inputActivityTime, "before")) {
										findResult+=a.getActivityDetails()+"\n\n";
									}
									System.out.println(findResult);
								}
								//查找活动（按照时间筛选_输入时间后的活动）--输入“fATa+时间”(eg:ATa2017.01.01)
								if(input.substring(0,4).equals("fATa")) {
									String inputActivityTime=input.substring(4);
									String findResult="";
									for(Activity a:aBoard.chooseActivityByTime(inputActivityTime, "after")) {
										findResult+=a.getActivityDetails()+"\n\n";
									}
									System.out.println(findResult);
								}
							}						     
							else {
								//查找活动（默认查找活动名）--输入“fA+活动名”(eg:fA小提琴演奏)
								String inputActivityName=input.substring(2);
								System.out.println(aBoard.searchActivityByName(inputActivityName).getActivityDetails());
							}
						}					
					}
					System.out.println(USER_GOON_TIPS);
					input=reader.next();
				}
				System.out.println("再见啦朋友");
				System.exit(0);
			}
			//管理员操作
			if(input.equals("m")) {			
				System.out.println(MANAGER_COMEIN_TIPS);
				//自动显示所有社团列表和活动列表
				System.out.println(aBoard.displayAllClubsName());
				System.out.println(aBoard.displayAllActivitiesName());
				System.out.println("请输入：");
				input=reader.next();
				while(!input.equals("t")) {
					//查看社团详情
					if(input.substring(0,2).equals("gC")) {
						//管理员"特"权—————查看某个社团的所有成员列表 --输入“gCM+社团编号”(eg:gCM1,gcM2...)
						if(input.substring(0,3).equals("gCM")) {
							System.out.println(input.substring(3));
							int inputClubID=Integer.parseInt(input.substring(3));
							System.out.println(aBoard.getAllMembersInAClub(inputClubID));
						}
						else {
							//查看社团详情 --输入“gC+编号”(eg:gC1,gC2...)
							int inputClubID=Integer.parseInt(input.substring(2));
							System.out.println(aBoard.getDetails(inputClubID, "club"));
						}
						
					}
					//查看活动详情 --输入“gA+编号”(eg:gA1,gA2...)
					if(input.substring(0,2).equals("gA")) {
						int inputActivityID=Integer.parseInt(input.substring(2));
						System.out.println(aBoard.getDetails(inputActivityID, "activity"));
					}
					//查找社团 --输入“fC+社团名”(eg:fC话剧社)
					if(input.substring(0,2).equals("fC")) {
						String inputClubName=input.substring(2);
						System.out.println(aBoard.searchClubByName(inputClubName).getClubDetails());
					}
					//查找活动
					if(input.substring(0,2).equals("fA")) {
						//查找活动（按照社团筛选）--输入“fAC+社团名”(eg:AC话剧社)
						if(input.substring(0,3).equals("fAC")) {
							String inputClubName=input.substring(3);
							String findResult="";
							for(Activity a:aBoard.chooseActivityByClub(inputClubName)) {
								findResult+=a.getActivityDetails()+"\n\n";
							}
							System.out.println(findResult);
						}
						else {
							if(input.substring(0,3).equals("fAT")) {
							    //查找活动（按照时间筛选_输入时间前的活动）--输入“fATb+时间”(eg:ATb2017.01.01)
								if(input.substring(0,4).equals("fATb")) {
									String inputActivityTime=input.substring(4);
									String findResult="";
									for(Activity a:aBoard.chooseActivityByTime(inputActivityTime, "before")) {
										findResult+=a.getActivityDetails()+"\n\n";
									}
									System.out.println(findResult);
								}
								//查找活动（按照时间筛选_输入时间后的活动）--输入“fATa+时间”(eg:ATa2017.01.01)
								if(input.substring(0,4).equals("fATa")) {
									String inputActivityTime=input.substring(4);
									String findResult="";
									for(Activity a:aBoard.chooseActivityByTime(inputActivityTime, "after")) {
										findResult+=a.getActivityDetails()+"\n\n";
									}
									System.out.println(findResult);
								}
							}						     
							else {
								//查找活动（默认查找活动名）--输入“fA+活动名”(eg:fA小提琴演奏)
								String inputActivityName=input.substring(2);
								System.out.println(aBoard.searchActivityByName(inputActivityName).getActivityDetails());
							}
						}					
					}
					//管理员特权					
					//对社团进行排序 --输入“rC+排序规则(activityTimes/memberNumbers)”(eg:rCmemberNumbers)
					if(input.substring(0,2).equals("rC")) {
						String inputRule=input.substring(2);
						System.out.println(aBoard.rankClubs(inputRule));
					}
					//所有活动信息汇总 --输入“allA”
					if(input.equals("allA")) {
						System.out.println(aBoard.collectAllActivities());
					}
					//添加活动补充信息 --输入“addA+活动编号,类型名称,人员名称数组”(eg:addA12,参与者,陈刚、李铁)
					if(input.length()>4) {
						if(input.substring(0,4).equals("addA")) {
							String[] inputInfo=input.substring(4).split(",");
							int inputActivityID=Integer.parseInt(inputInfo[0]);
							String inputType=inputInfo[1];
							String[] inputParticipatorsArray=inputInfo[2].split("、");
							
							System.out.println("添加之前：\n"
									+ aBoard.getDetails(inputActivityID, "activity"));
							aBoard.addANewRemark(inputActivityID, inputType, inputParticipatorsArray);
							System.out.println("\n添加之后： \n"
									+ aBoard.getDetails(inputActivityID, "activity"));
						}
						//删除活动补充信息 --输入“delA+活动编号,类型名称”(eg:delA1,参演者)
						if(input.substring(0,4).equals("delA")) {
							String[] inputInfo=input.substring(4).split(",");
							int inputActivityID=Integer.parseInt(inputInfo[0]);
							String inputType=inputInfo[1];
							
							System.out.println("删除之前：\n"
									+ aBoard.getDetails(inputActivityID, "activity"));
							aBoard.deleteRemark(inputActivityID, inputType);
							System.out.println("\n删除之后： \n"
									+ aBoard.getDetails(inputActivityID, "activity"));
						}
						//修改活动补充信息 --输入“updA+活动编号,原来类型,修改后类型,人员名称数组”(eg:addA3,演讲人,主持人,陈刚、李铁)
						if(input.substring(0,4).equals("updA")) {
							String[] inputInfo=input.substring(4).split(",");
							int inputActivityID=Integer.parseInt(inputInfo[0]);
							String inputTypeBefore=inputInfo[1];
							String inputTypeAfter=inputInfo[2];
							String[] inputParticipatorsArray=inputInfo[3].split("、");
							
							System.out.println("修改之前：\n"
									+ aBoard.getDetails(inputActivityID, "activity"));
							aBoard.updateRemark(inputActivityID, inputTypeBefore, inputTypeAfter, inputParticipatorsArray);
							System.out.println("\n修改之后： \n"
									+ aBoard.getDetails(inputActivityID, "activity"));
						}
					}
					
					System.out.println(MANAGER_GOON_TIPS);
					input=reader.next();
				}
				System.out.println("再见啦朋友");
				System.exit(0);
			}
//			
					
		}
}
