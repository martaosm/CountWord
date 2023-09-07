package com.example.demo.service

import org.springframework.stereotype.Service


@Service
class CountThisService {

    List<List<Serializable>> countWord(String word) {
        List<List<Serializable>> result = new ArrayList<>()
        for (int i = 0; i < word.length(); i++) {
            int count = 0
            for(int y = 0; y < word.length(); y++){
                if(word[i] == word[y])
                    count++
            }
            result.add([word[i],count])
        }
        result.stream().distinct().toList()
    }
}
