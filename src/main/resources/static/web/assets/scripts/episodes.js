setTimeout(() => {
    let { createApp } = Vue;
    createApp({
        data() {
            return {
                current: [],
                episodes: [],
                filteredEp: [],
                seasons: [],
                checked: [],
                searchInput: '',
                isLoading: false
            }
        },
        created() {
            this.getCurrent()
            this.getEpisodes()
        },
    methods: {
        getCurrent(){
            axios.get(`/api/getCurrent`)
            .then(res => {
                this.current = res.data
                console.log(this.current)
            }).catch(err => console.log(err))
        },
        getEpisodes(){
            axios.get(`/api/episodes`)
            .then(res => {
                this.episodes = res.data
                this.seasons = Array.from(new Set(this.episodes.map(episode => episode.seasonNumber)))
            }).catch(err => console.log(err))
        },
        filtroEpCheckSearc2() {
            this.filteredEp = this.episodes.filter(episode => episode.name.toLowerCase().includes(this.searchInput.toLowerCase())
            && (this.checked.includes(episode.seasonNumber) || this.checked.length == 0)).sort((a, b) => b.id - a.id)
        }
    },
    computed: {
        filtroEpCheckSearch() {
            this.filteredEp = this.episodes.filter(episode => episode.name.toLowerCase().includes(this.searchInput.toLowerCase())
            && (this.checked.includes(episode.seasonNumber) || this.checked.length == 0)).sort((a, b) => b.id - a.id)
        }
    }
}).mount("#app")
},1000)