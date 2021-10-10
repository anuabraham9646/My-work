import React , {useState,useEffect}from 'react'
import axios from 'axios'
import {useParams} from 'react-router-dom'
import { MatchDetailCard } from '../components/MatchDetailCard'
import { MatchSmallCard } from '../components/MatchSmallCard'

export const TeamPage = () =>{

    const {teamName}= useParams();
    const [team,setTeam]=useState({matches: []}) //this was crucial initialize empty matches array during declaration or else map is undefined
    useEffect(
        ()=>{
            console.log("hey effect")
            axios.get(`http://localhost:8080/team/${teamName}?size=5`)
        .   then(res =>{
            console.log(res.data)
            setTeam(res.data)
        })
        },[]
    )

    if(!team || !team.teamName){
        return <h1>Team Not Found</h1>
    }
        
    return (
        <div className= "TeamPage">
            
            <h1>{team.teamName}</h1>
            <MatchDetailCard teamAbbr = {teamName} match={team.matches[0]}/>
            {team.matches.slice(1).map(matches => <MatchSmallCard key={matches.id} teamAbbr = {teamName} match={matches}/>)}
        </div>
    )
}


