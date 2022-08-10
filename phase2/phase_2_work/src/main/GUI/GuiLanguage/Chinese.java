package GUI.GuiLanguage;

/**
 * This class is responsible for Chinese Language.
 */
public class Chinese implements ILanguage {
    public Chinese() {
    }
    @Override
    public String register(){
        return "注册";
    }

    public String chooseUserToPromote(){
        return "选择要提升成管理员的用户";
    }

    public String chooseUserToDelete(){
        return "选择需要删除的用户";
    }

    public String chooseUserToBan(){
        return "选择封号的用户";
    }

    public String homepageAdminUser(){
        return "管理员的主页面";
    }

    public String notification(){
        return "信息";
    }

    public String recommend() {
        return "推荐";
    }

    public String admin(){
        return "管理员";
    }

    @Override
    public String other() {
        return "其他";
    }

    @Override
    public String exit() {
        return "退出";
    }

    @Override
    public String checkHistory() {
        return "查看历史登录记录";
    }

    @Override
    public String logout() {
        return "登出";
    }

    @Override
    public String checkNewNotifications() {
        return "查看最新通知";
    }

    @Override
    public String checkAllNotifications() {
        return "查看所有通知";
    }

    @Override
    public String getRecommendSongs() {
        return "获取推荐歌曲";
    }

    @Override
    public String rateASong() {
        return "为歌曲评分";
    }

    @Override
    public String recommendToUser() {
        return "推荐歌曲";
    }

    @Override
    public String user() {
        return "用户";
    }

    @Override
    public String ban() {
        return "封号";
    }

    @Override
    public String delete() {
        return "删除";
    }

    @Override
    public String userName() {
        return "用户名";
    }

    @Override
    public String search() {
        return "查询";
    }

    @Override
    public String newNotifications() {
        return "新通知";
    }

    @Override
    public String allNotifications() {
        return "所有通知";
    }

    @Override
    public String recommendSongs() {
        return "推荐歌曲";
    }

    @Override
    public String listen() {
        return "听歌";
    }

    @Override
    public String songURL() {
        return "歌曲链接";
    }

    @Override
    public String loginSystem() {
        return "登录系统";
    }

    @Override
    public String userID() {
        return "用户名";
    }

    @Override
    public String password() {
        return "密码";
    }

    @Override
    public String login() {
        return "登陆";
    }

    @Override
    public String songName() {
        return "歌曲名字";
    }

    @Override
    public String rate() {
        return "打分";
    }

    @Override
    public String yes() {
        return "是";
    }

    @Override
    public String forExistedUser() {
        return "已注册用户";
    }

    @Override
    public String forNewUser() {
        return "新用户";
    }
    @Override
    public String LoginHistory() {
        return "登录历史";
    }

    @Override
    public String homepageNormalUser() {
        return "普通用户主界面";
    }

    @Override
    public String registerSystem(){
        return"注册系统";
    }

    @Override
    public String back() {
        return "返回";
    }

    @Override
    public String logInFailed() {
        return "密码或用户名错误";
    }

    @Override
    public String registerFailed() {
        return "用户名已被占用，请重试";
    }

    @Override
    public String logoutFailed() {
        return "您已成功登出，但您的用户数据无法保存";
    }

    @Override
    public String welcome() {
        return "欢迎";
    }
    @Override
    public String userInfo() {
        return "用户信息";
    }
}
