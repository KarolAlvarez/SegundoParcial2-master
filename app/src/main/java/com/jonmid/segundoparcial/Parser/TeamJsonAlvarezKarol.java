package com.jonmid.segundoparcial.Parser;

import com.jonmid.segundoparcial.Model.TeamModelAlvarezKarol;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 17/10/17.
 */

public class TeamJsonAlvarezKarol {


    public static List<TeamModelAlvarezKarol> getData(String content) throws JSONException {
        JSONObject jsonObject = new JSONObject(content);
        JSONArray jsonArray=jsonObject.getJSONArray("teams");

        List<TeamModelAlvarezKarol> teamModelAlvarezKarolList = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject item = jsonArray.getJSONObject(i);
            TeamModelAlvarezKarol teamModelAlvarezKarol = new TeamModelAlvarezKarol();
            teamModelAlvarezKarol.setName(item.getString("name"));
            teamModelAlvarezKarol.setCode(item.getString("code"));
            teamModelAlvarezKarol.setCrestUrl(item.getString("crestUrl"));

            teamModelAlvarezKarolList.add(teamModelAlvarezKarol);
        }
        return teamModelAlvarezKarolList;
    }




}
