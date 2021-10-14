package com.example.fragmentbottomnavigation;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class ChatFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
//    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;

    private RecyclerView rvChat;
    private ArrayList<Chats> list = new ArrayList<>();

    public ChatFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
     * @return A new instance of fragment ChatFragment.
     */
    // TODO: Rename and change types and number of parameters
//    public static ChatFragment newInstance(String param1, String param2) {
//        ChatFragment fragment = new ChatFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }

//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//
//
////        if (getArguments() != null) {
////            mParam1 = getArguments().getString(ARG_PARAM1);
////            mParam2 = getArguments().getString(ARG_PARAM2);
////        }
//    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_chat, container, false);
        rvChat = view.findViewById(R.id.listView);
        rvChat.setHasFixedSize(true);
        list.addAll(ChatsAdapter.getListData());
        showRecyclerList();
        return view;
    }

    private void showRecyclerList(){
        rvChat.setLayoutManager(new LinearLayoutManager(getContext()));
        ChatsListAdapter listAdapter = new ChatsListAdapter(list, getContext());
        rvChat.setAdapter(listAdapter);
        listAdapter.setOnItemClickCallback(new ChatsListAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Chats data) {
                showSelected(data);
            }
        });
    }

    private void showSelected (Chats chats){
        Toast.makeText(getContext(), "Kamu memilih pesan dari " + chats.getName(), Toast.LENGTH_SHORT).show();
    }
}