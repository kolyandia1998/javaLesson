package Task15.Controllers;

import Task14v1.Rewards;
import Task14v1.User.Users;
import Task15.Repository.Repository;
import Task15.View.MainView;
import Task15.View.RewardForm;
import Task15.View.RewardsList;
import Task15.View.UserForm;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.time.LocalDate;

public class Controller {

    private MainView mainView;

    private Repository repository = new Repository();

    public Controller(MainView mainView) {
        this.mainView = mainView;
    }

    private void setTableData() {
        mainView.getUserID().setCellValueFactory(new PropertyValueFactory<Users, Integer>("id"));
        mainView.getUserName().setCellValueFactory(new PropertyValueFactory<Users, String>("FirstName"));
        mainView.getUserSecondName().setCellValueFactory(new PropertyValueFactory<Users, String>("LastName"));
        mainView.getUserBirthday().setCellValueFactory(new PropertyValueFactory<Users, LocalDate>("BirthDay"));
        mainView.getUserAge().setCellValueFactory(new PropertyValueFactory<Users, Integer>("Age"));
        mainView.getRewardID().setCellValueFactory(new PropertyValueFactory<Rewards, Integer>("id"));
        mainView.getRewardTittle().setCellValueFactory(new PropertyValueFactory<Rewards, String>("Tittle"));
        mainView.getRewardDescription().setCellValueFactory(new PropertyValueFactory<Rewards, String>("Description"));
        /*UserStrRewards.setCellValueFactory(new PropertyValueFactory<Users, String>("rewardsStrId"));*/
        mainView.getUserTable().setItems(repository.getUsersRepository());
        mainView.getRewardTable().setItems(repository.getRewardsRepository());
    }

    public void setView() {
        mainView.getAdd().setOnAction(event -> {
                    if (mainView.getRewards().isSelected()) {
                        RewardForm rewardForm = new RewardForm();
                        rewardForm.startForm(event1 -> {
                            repository.AddReward(new Rewards(rewardForm.getRewardDescription().getText(), rewardForm.getRewardTittle().getText()));
                            ((Stage) ((Node) event1.getSource()).getScene().getWindow()).close();
                        });
                    } else if (mainView.getUsers().isSelected()) {
                        UserForm userForm = new UserForm();
                        userForm.startForm(
                                eventSave -> {
                                    Users userFromForm = new Users(userForm.getUserName().getText(), userForm.getUserSecondName().getText(), userForm.getUserBirthday().getValue());
                                    userFromForm.rewards.addAll(userForm.getRewardsTable().getItems());
                                    repository.AddUser(userFromForm);
                                    ((Stage) ((Node) eventSave.getSource()).getScene().getWindow()).close();
                                },
                                eventAdd -> {
                                    RewardsList rewardsList = new RewardsList();
                                    rewardsList.getRewardID().setCellValueFactory(new PropertyValueFactory<Rewards, Integer>("id"));
                                    rewardsList.getRewardTittle().setCellValueFactory(new PropertyValueFactory<Rewards, String>("Tittle"));
                                    rewardsList.getRewardDescription().setCellValueFactory(new PropertyValueFactory<Rewards, String>("Description"));
                                    rewardsList.getRewardTable().setItems(repository.getRewardsRepository());
                                    rewardsList.startForm(event1 -> {

                                        Rewards selectedRewards = rewardsList.getRewardTable().getSelectionModel().getSelectedItem();
                                        if (selectedRewards != null && !userForm.getRewardsTable().getItems().contains(selectedRewards)) {
                                            userForm.getRewardsTable().getItems().add(selectedRewards);
                                            ((Stage) ((Node) event1.getSource()).getScene().getWindow()).close();
                                            userForm.getRewardID().setCellValueFactory(new PropertyValueFactory<Rewards, Integer>("id"));
                                            userForm.getRewardTittle().setCellValueFactory(new PropertyValueFactory<Rewards, String>("Tittle"));
                                            userForm.getRewardsTable().refresh();
                                        }
                                    });
                                },
                                eventDelete -> {
                                    Rewards selectedRewards = userForm.getRewardsTable().getSelectionModel().getSelectedItem();
                                    if (selectedRewards != null)
                                        userForm.getRewardsTable().getItems().remove(selectedRewards);
                                });
                    }
                }
        );
        mainView.getEdit().setOnAction(event -> {
            if (mainView.getRewards().isSelected() && mainView.getRewardTable().getSelectionModel().getSelectedItem() != null) {
                RewardForm rewardForm = new RewardForm();
                Rewards selectedReward = mainView.getRewardTable().getSelectionModel().getSelectedItem();
                rewardForm.getRewardDescription().setText(selectedReward.getDescription());
                rewardForm.getRewardTittle().setText(selectedReward.getTittle());
                rewardForm.startForm(event1 -> {
                    selectedReward.setDescription(rewardForm.getRewardDescription().getText());
                    selectedReward.setTittle(rewardForm.getRewardTittle().getText());
                    ((Stage) ((Node) event1.getSource()).getScene().getWindow()).close();
                    mainView.getRewardTable().refresh();
                });
            } else if (mainView.getUsers().isSelected() && mainView.getUserTable().getSelectionModel().getSelectedItem() != null) {
                UserForm userForm = new UserForm();
                userForm.getRewardID().setCellValueFactory(new PropertyValueFactory<Rewards, Integer>("id"));
                userForm.getRewardTittle().setCellValueFactory(new PropertyValueFactory<Rewards, String>("Tittle"));
                userForm.getRewardsTable().refresh();
                Users selectedUser = mainView.getUserTable().getSelectionModel().getSelectedItem();
                userForm.getUserSecondName().setText(selectedUser.getLastName());
                userForm.getUserName().setText(selectedUser.getFirstName());
                userForm.getUserBirthday().setValue(selectedUser.getBirthDay());
                userForm.getRewardsTable().getItems().addAll(selectedUser.rewards);
                userForm.getRewardsTable().refresh();
                userForm.startForm(
                        eventSave -> {
                            selectedUser.setFirstName(userForm.getUserName().getText());
                            selectedUser.setLastName(userForm.getUserSecondName().getText());
                            selectedUser.setBirthDay(userForm.getUserBirthday().getValue());
                            selectedUser.rewards.clear();
                            selectedUser.rewards.addAll(userForm.getRewardsTable().getItems());
                            ((Stage) ((Node) eventSave.getSource()).getScene().getWindow()).close();
                            mainView.getUserTable().refresh();
                        },
                        eventAdd -> {
                            RewardsList rewardsList = new RewardsList();
                            rewardsList.getRewardID().setCellValueFactory(new PropertyValueFactory<Rewards, Integer>("id"));
                            rewardsList.getRewardTittle().setCellValueFactory(new PropertyValueFactory<Rewards, String>("Tittle"));
                            rewardsList.getRewardDescription().setCellValueFactory(new PropertyValueFactory<Rewards, String>("Description"));
                            rewardsList.getRewardTable().setItems(repository.getRewardsRepository());
                            rewardsList.startForm(event1 -> {
                                Rewards selectedRewards = rewardsList.getRewardTable().getSelectionModel().getSelectedItem();
                                if (selectedRewards != null) {
                                    userForm.getRewardsTable().getItems().add(selectedRewards);
                                    ((Stage) ((Node) event1.getSource()).getScene().getWindow()).close();
                                    userForm.getRewardID().setCellValueFactory(new PropertyValueFactory<Rewards, Integer>("id"));
                                    userForm.getRewardTittle().setCellValueFactory(new PropertyValueFactory<Rewards, String>("Tittle"));
                                    userForm.getRewardsTable().refresh();
                                }
                            });
                        },
                        eventDelete -> {
                            Rewards selectedRewards = userForm.getRewardsTable().getSelectionModel().getSelectedItem();
                            if (selectedRewards != null)
                                userForm.getRewardsTable().getItems().remove(selectedRewards);
                        }
                );
            }
        });
        mainView.getDelete().setOnAction(event -> {
            if (mainView.getRewards().isSelected() && mainView.getRewardTable().getSelectionModel().getSelectedItem() != null) {
                Rewards selectedReward = mainView.getRewardTable().getSelectionModel().getSelectedItem();
                repository.getRewardsRepository().remove(selectedReward);
                for (Users user : repository.getUsersRepository()) {
                    if (user.rewards.contains(selectedReward)) {
                        user.rewards.remove(selectedReward);
                    }
                }
                mainView.getRewardTable().refresh();
            } else if (mainView.getUsers().isSelected() && mainView.getUserTable().getSelectionModel().getSelectedItem() != null) {
                Users selectedUser = mainView.getUserTable().getSelectionModel().getSelectedItem();
                repository.getUsersRepository().remove(selectedUser);
                mainView.getUserTable().refresh();
            }
        });
        setTableData();
        mainView.startForm();
    }
}
